package com.groundzero.camw.features.chat.chatroom.data

import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.core.service.ReadJsonService
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import com.groundzero.camw.features.chat.chatroom.service.ChatRoomPeriodicCacheService
import org.springframework.stereotype.Component

@Component
class ChatRoomRepository(
    private val readJsonService: ReadJsonService,
    private val mapper: Mapper<ChatRoomMessageRequest, ChatRoomMessageResponse>
) : ChatRoomPersistenceRepository, ChatRoomMessagesRepository {

    private var roomMessagesMap = mutableMapOf<String, MutableList<ChatRoomMessageResponse>>()

    // TODO decouple logic from this repository function
    override fun getMessagesPerRoomId(
        roomId: String,
        request: ChatRoomMessageRequest
    ): MutableList<ChatRoomMessageResponse>? {

        val responseMessage = mapper.map(request)

        val messages: MutableList<ChatRoomMessageResponse>

        if (!request.showMessage) {
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

    override fun retrieveMessagesFromMemory() = roomMessagesMap
    override fun retrieveMessagesFromJsonStorage() {
        val jsonStoredMessages =
            readJsonService.read<Map<String, MutableList<ChatRoomMessageResponse>>>(ChatRoomPeriodicCacheService.CACHED_MESSAGES_FILE_NAME)
        jsonStoredMessages?.let { roomMessagesMap.putAll(it) }
    }
}