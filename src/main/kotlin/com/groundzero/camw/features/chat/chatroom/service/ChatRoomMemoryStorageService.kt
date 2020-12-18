package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import org.springframework.stereotype.Service

@Service
class ChatRoomMemoryStorageService(private val mapper: Mapper<ChatRoomMessageRequest, ChatRoomMessageResponse>) {

    private var roomMessagesMap = mutableMapOf<String, List<ChatRoomMessageResponse>>()

    fun storeMessage(roomId: String, request: ChatRoomMessageRequest) {
        val responseMessage = mapper.map(request)

        val messages: List<ChatRoomMessageResponse>

        if (!request.showMessage) {
            return
        }
        if (roomMessagesMap.containsKey(roomId)) {
            messages = roomMessagesMap[roomId]!!
            messages.toMutableList().add(responseMessage)
        } else {
            messages = mutableListOf(responseMessage)
        }

        roomMessagesMap[roomId] = messages
    }

    fun getMessages(roomId: String): List<ChatRoomMessageResponse> =
        if (roomMessagesMap.containsKey(roomId)) {
            roomMessagesMap[roomId]!!
        } else
            mutableListOf()

    fun getAllMemoryMessages(): Map<String, List<ChatRoomMessageResponse>> = roomMessagesMap
    fun setJsonStorageMessages(roomMessagesMap: Map<String, List<ChatRoomMessageResponse>>) {
        this.roomMessagesMap.clear()
        this.roomMessagesMap.putAll(roomMessagesMap)
    }
}