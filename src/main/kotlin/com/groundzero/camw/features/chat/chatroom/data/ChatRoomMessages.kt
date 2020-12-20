package com.groundzero.camw.features.chat.chatroom.data

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessage

data class ChatRoomMessages(
    val roomId: String = "",
    val roomMessages: List<ChatRoomMessage> = listOf()
)