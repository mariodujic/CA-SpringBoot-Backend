package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest

interface ChatRoomMessagesService {

    fun insertMessage(roomId: String, messageRequest: ChatRoomMessageRequest)
    fun updateMessage(roomId: String, messageRequest: ChatRoomMessageRequest)
    fun deleteMessage(roomId: String, messageId: String)
    fun getMessagesPerRoomId(roomId: String): List<ChatRoomMessageResponse>
}