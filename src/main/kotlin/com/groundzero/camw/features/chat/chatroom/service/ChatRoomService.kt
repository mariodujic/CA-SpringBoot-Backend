package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import org.springframework.stereotype.Component

@Component
class ChatRoomService(private val mapper: Mapper<ChatRoomMessageRequest, ChatRoomMessageResponse>) {

    private val map = mutableMapOf<String, MutableList<ChatRoomMessageResponse>>()

    fun getRoomMessages(roomId: String, messageRequest: ChatRoomMessageRequest): MutableList<ChatRoomMessageResponse>? {

        val responseMessage = mapper.map(messageRequest)

        val messages: MutableList<ChatRoomMessageResponse>

        if (!messageRequest.showMessage) {
            return map[roomId]
        }
        if (map.containsKey(roomId)) {
            messages = map[roomId]!!
            messages.add(responseMessage)
        } else {
            messages = mutableListOf(responseMessage)
        }

        map[roomId] = messages

        return map[roomId]
    }
}