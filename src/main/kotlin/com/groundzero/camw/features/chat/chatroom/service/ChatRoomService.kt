package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.features.chat.chatroom.data.ChatRoomTempStorage
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import org.springframework.stereotype.Component

@Component
class ChatRoomService(private val storage: ChatRoomTempStorage) {
    fun getMessagesPerRoomId(roomId: String, messageRequest: ChatRoomMessageRequest) =
        storage.getMessagesPerRoomId(roomId, messageRequest)
}