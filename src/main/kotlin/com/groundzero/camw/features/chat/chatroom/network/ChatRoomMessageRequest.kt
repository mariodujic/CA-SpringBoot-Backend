package com.groundzero.camw.features.chat.chatroom.network

data class ChatRoomMessageRequest(
    val messageId: String,
    val userId: String,
    val message: String,
    val messageType: Int
) {

    enum class MessageType(val type: Int) {
        INITIAL(0),
        WRITE(1),
        UPDATE(2),
        DELETE(3);

        companion object {
            fun getType(type: Int): MessageType? = values().find { it.type == type }
        }
    }
}