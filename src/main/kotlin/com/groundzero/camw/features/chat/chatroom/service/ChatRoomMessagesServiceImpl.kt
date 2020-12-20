package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.features.chat.chatroom.data.ChatRoomMessagesRepository
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import org.springframework.stereotype.Service

@Service
class ChatRoomMessagesServiceImpl(
    private val chatRoomMessagesRepository: ChatRoomMessagesRepository
) : ChatRoomMessagesService {

    override fun insertMessage(roomId: String, messageRequest: ChatRoomMessageRequest) =
        chatRoomMessagesRepository.insertMessage(roomId, messageRequest)

    override fun updateMessage(roomId: String, messageRequest: ChatRoomMessageRequest) =
        chatRoomMessagesRepository.updateMessage(roomId, messageRequest)

    override fun deleteMessage(roomId: String, messageId: String) =
        chatRoomMessagesRepository.deleteMessage(roomId, messageId)

    override fun getMessagesPerRoomId(roomId: String) =
        chatRoomMessagesRepository.getMessagesPerRoomIdFromMemory(roomId)
}