package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.features.chat.chatroom.data.ChatRoomMessagesRepository
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import org.springframework.stereotype.Service

@Service
class ChatRoomMessagesService(private val chatRoomMessagesRepository: ChatRoomMessagesRepository) {

    fun getMessagesPerRoomId(roomId: String) = chatRoomMessagesRepository.getMessagesPerRoomIdFromMemory(roomId)
    fun insertMessage(roomId: String, messageRequest: ChatRoomMessageRequest) =
        chatRoomMessagesRepository.insertMessageToMemory(roomId, messageRequest)
}