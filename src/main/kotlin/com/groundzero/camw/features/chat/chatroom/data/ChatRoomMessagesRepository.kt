package com.groundzero.camw.features.chat.chatroom.data

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessage

interface ChatRoomMessagesRepository {
    fun handleMessage(roomId: String, request: ChatRoomMessageRequest)
    fun getMessagesPerRoomIdFromMemory(roomId: String): List<ChatRoomMessage>
}