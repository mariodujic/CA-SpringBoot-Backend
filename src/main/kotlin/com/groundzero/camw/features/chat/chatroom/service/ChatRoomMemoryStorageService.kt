package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.features.chat.chatroom.data.ChatRoomMessages
import com.groundzero.camw.features.chat.chatroom.mapper.ChatRoomMessageRequestToMessageType
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessage
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import org.springframework.stereotype.Service

@Service
class ChatRoomMemoryStorageService(
    private val mapper: Mapper<ChatRoomMessageRequest, ChatRoomMessage>,
    private val maxMessagesRestrictionService: ChatRoomMaxMessagesRestrictionService,
    private val messageRequestToMessageType: ChatRoomMessageRequestToMessageType,
) {

    private var roomMessagesList = listOf<ChatRoomMessages>()

    fun handleMessage(roomId: String, request: ChatRoomMessageRequest) {

        val messageType = messageRequestToMessageType.map(request)
        val responseMessage = mapper.map(request)

        when (messageType) {
            ChatRoomMessageRequest.MessageType.INITIAL -> return
            ChatRoomMessageRequest.MessageType.WRITE -> addMessageOrCreateRoom(roomId, responseMessage)
            ChatRoomMessageRequest.MessageType.UPDATE -> updateMessage(roomId, responseMessage)
            ChatRoomMessageRequest.MessageType.DELETE -> deleteMessage(roomId, responseMessage)
        }
    }

    private fun addMessageOrCreateRoom(roomId: String, responseMessage: ChatRoomMessage) {
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

    private fun updateMessage(roomId: String, updatedMessage: ChatRoomMessage) {
        roomMessagesList = roomMessagesList.map {
            if (it.roomId == roomId) {
                val updatedMessages = it.roomMessages.map {message->
                    if (message.messageId == updatedMessage.messageId) {
                        updatedMessage
                    } else message
                }
                ChatRoomMessages(roomId, updatedMessages)
            } else it
        }
    }

    private fun deleteMessage(roomId: String, responseMessage: ChatRoomMessage) {
        roomMessagesList = roomMessagesList.map {
            if (it.roomId == roomId) {
                val updatedMessages = it.roomMessages.toMutableList().apply {
                    removeIf { message -> message.messageId == responseMessage.messageId }
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