package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.features.chat.chatroom.data.ChatRoomMessagesRepository
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import org.springframework.stereotype.Service

@Service
class ChatRoomMessagesService(private val chatRoomMessagesRepository: ChatRoomMessagesRepository) {

    fun insertMessage(roomId: String, messageRequest: ChatRoomMessageRequest) =
        chatRoomMessagesRepository.insertMessage(roomId, messageRequest)

    fun updateMessage(roomId: String, messageRequest: ChatRoomMessageRequest) =
        chatRoomMessagesRepository.updateMessage(roomId, messageRequest)

    fun deleteMessage(roomId: String, messageId: String) =
        chatRoomMessagesRepository.deleteMessage(roomId, messageId)

    fun getMessagesPerRoomId(roomId: String) = chatRoomMessagesRepository.getMessagesPerRoomIdFromMemory(roomId)
}