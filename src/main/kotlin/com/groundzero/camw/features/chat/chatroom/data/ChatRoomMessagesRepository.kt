package com.groundzero.camw.features.chat.chatroom.data

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse

interface ChatRoomMessagesRepository {
    fun getMessagesPerRoomId(roomId: String, request: ChatRoomMessageRequest): MutableList<ChatRoomMessageResponse>?
}