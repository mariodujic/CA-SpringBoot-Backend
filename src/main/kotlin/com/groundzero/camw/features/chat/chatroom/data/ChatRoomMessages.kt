package com.groundzero.camw.features.chat.chatroom.data

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse

data class ChatRoomMessages(
    val roomId: String = "",
    val roomMessages: List<ChatRoomMessageResponse> = listOf()
)