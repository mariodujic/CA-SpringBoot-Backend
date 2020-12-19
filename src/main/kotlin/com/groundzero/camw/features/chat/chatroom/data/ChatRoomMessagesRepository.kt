package com.groundzero.camw.features.chat.chatroom.data

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse

interface ChatRoomMessagesRepository {
    fun insertMessageToMemory(roomId: String, request: ChatRoomMessageRequest)
    fun getMessagesPerRoomIdFromMemory(roomId: String): List<ChatRoomMessageResponse>
}