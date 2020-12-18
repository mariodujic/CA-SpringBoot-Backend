package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.core.service.ReadJsonService
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import org.springframework.stereotype.Service

@Service
class ChatRoomJsonStorageService(private val readJsonService: ReadJsonService) {
    fun getAllMessagesFromJsonStorage() =
        readJsonService.read<Map<String, List<ChatRoomMessageResponse>>>(ChatRoomPeriodicCacheService.CACHED_MESSAGES_FILE_NAME)
            ?: emptyMap()
}