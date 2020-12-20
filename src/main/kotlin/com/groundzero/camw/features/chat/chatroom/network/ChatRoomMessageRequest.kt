package com.groundzero.camw.features.chat.chatroom.network

data class ChatRoomMessageRequest(
    val messageId: String,
    val userId: String,
    val message: String
)