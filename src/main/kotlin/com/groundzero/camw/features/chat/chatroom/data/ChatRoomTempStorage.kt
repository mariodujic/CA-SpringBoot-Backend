package com.groundzero.camw.features.chat.chatroom.data

import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import org.springframework.stereotype.Component

@Component
class ChatRoomTempStorage(private val mapper: Mapper<ChatRoomMessageRequest, ChatRoomMessageResponse>) {

    private val roomMessagesMap = mutableMapOf<String, MutableList<ChatRoomMessageResponse>>()

    fun getMessagesPerRoomId(roomId: String, messageRequest: ChatRoomMessageRequest): MutableList<ChatRoomMessageResponse>? {

        val responseMessage = mapper.map(messageRequest)

        val messages: MutableList<ChatRoomMessageResponse>

        if (!messageRequest.showMessage) {
            return if (roomMessagesMap.containsKey(roomId)) {
                roomMessagesMap[roomId]
            } else mutableListOf()
        }
        if (roomMessagesMap.containsKey(roomId)) {
            messages = roomMessagesMap[roomId]!!
            messages.add(responseMessage)
        } else {
            messages = mutableListOf(responseMessage)
        }

        roomMessagesMap[roomId] = messages

        return roomMessagesMap[roomId]
    }
}