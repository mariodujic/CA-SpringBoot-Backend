package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.features.chat.chatroom.data.ChatRoomMessages
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import org.springframework.stereotype.Service

@Service
class ChatRoomMemoryStorageServiceImpl(
    private val mapper: Mapper<ChatRoomMessageRequest, ChatRoomMessageResponse>,
    private val maxMessagesRestrictionService: ChatRoomMaxMessagesRestrictionService
) : ChatRoomMemoryStorageService {

    private var roomMessagesList = listOf<ChatRoomMessages>()

    override fun insertMessage(roomId: String, request: ChatRoomMessageRequest) {

        val responseMessage = mapper.map(request)

        roomMessagesList = if (roomMessagesList.hasRoom(roomId)) {
            roomMessagesList.map {
                if (it.roomId == roomId) {
                    val updatedMessages = maxMessagesRestrictionService(it.roomMessages).apply { add(responseMessage) }
                    ChatRoomMessages(roomId, updatedMessages)
                } else it
            }
        } else roomMessagesList.toMutableList().apply {
            add(ChatRoomMessages(roomId, listOf(responseMessage)))
        }
    }

    override fun updateMessage(roomId: String, request: ChatRoomMessageRequest) {
        roomMessagesList = roomMessagesList.map {
            if (it.roomId == roomId) {
                val updatedMessages = it.roomMessages.map { message ->
                    if (message.messageId == request.messageId) {
                        mapper.map(request)
                    } else message
                }
                ChatRoomMessages(roomId, updatedMessages)
            } else it
        }
    }

    override fun deleteMessage(roomId: String, messageId: String) {
        roomMessagesList = roomMessagesList.map {
            if (it.roomId == roomId) {
                val updatedMessages = it.roomMessages.toMutableList().apply {
                    removeIf { message -> message.messageId == messageId }
                }
                ChatRoomMessages(roomId, updatedMessages)
            } else it
        }
    }

    private fun List<ChatRoomMessages>.hasRoom(roomId: String) = this.map { it.roomId }.contains(roomId)

    override fun getMessagesPerRoomId(roomId: String): List<ChatRoomMessageResponse> =
        roomMessagesList.findLast { it.roomId == roomId }?.roomMessages ?: mutableListOf()

    override fun getAllMemoryMessages(): List<ChatRoomMessages> = roomMessagesList
    override fun setMessagesFromJsonStorage(roomMessagesList: List<ChatRoomMessages>) {
        this.roomMessagesList = roomMessagesList
    }
}