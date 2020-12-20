package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.features.chat.chatroom.data.ChatRoomMessages
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessage
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import org.springframework.stereotype.Service

@Service
class ChatRoomMemoryStorageService(
    private val mapper: Mapper<ChatRoomMessageRequest, ChatRoomMessage>,
    private val maxMessagesRestrictionService: ChatRoomMaxMessagesRestrictionService
) {

    private var roomMessagesList = listOf<ChatRoomMessages>()

    fun insertMessage(roomId: String, request: ChatRoomMessageRequest) {

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

    fun updateMessage(roomId: String, request: ChatRoomMessageRequest) {
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

    fun deleteMessage(roomId: String, messageId: String) {
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

    fun getMessagesPerRoomId(roomId: String): List<ChatRoomMessage> =
        roomMessagesList.findLast { it.roomId == roomId }?.roomMessages ?: mutableListOf()

    fun getAllMemoryMessages(): List<ChatRoomMessages> = roomMessagesList
    fun setMessagesFromJsonStorage(roomMessagesList: List<ChatRoomMessages>) {
        this.roomMessagesList = roomMessagesList
    }
}