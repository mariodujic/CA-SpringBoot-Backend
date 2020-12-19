package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import org.springframework.stereotype.Service

@Service
class ChatRoomMemoryStorageService(
    private val mapper: Mapper<ChatRoomMessageRequest, ChatRoomMessageResponse>,
    private val maxMessagesRestrictionService: ChatRoomMaxMessagesRestrictionService
) {

    private var roomMessagesMap = mutableMapOf<String, List<ChatRoomMessageResponse>>()

    fun storeMessage(roomId: String, request: ChatRoomMessageRequest) {

        val responseMessage = mapper.map(request)
        val messages: List<ChatRoomMessageResponse>

        if (!request.showMessage) {
            return
        }

        messages = roomMessagesMap[roomId]?.let {
            maxMessagesRestrictionService(it).apply { add(responseMessage) }
        } ?: mutableListOf(responseMessage)

        roomMessagesMap[roomId] = messages
    }

    fun getMessagesPerRoomId(roomId: String): List<ChatRoomMessageResponse> =
        if (roomMessagesMap.containsKey(roomId)) {
            roomMessagesMap[roomId]!!
        } else
            mutableListOf()

    fun getAllMemoryMessages(): Map<String, List<ChatRoomMessageResponse>> = roomMessagesMap
    fun setMessagesFromJsonStorage(roomMessagesMap: Map<String, List<ChatRoomMessageResponse>>) {
        this.roomMessagesMap.clear()
        this.roomMessagesMap.putAll(roomMessagesMap)
    }
}