package com.groundzero.camw.features.chat.chatroom.network

data class ChatRoomMessageRequest(
    val userId: String,
    val message: String,
    val showMessage: Boolean
)