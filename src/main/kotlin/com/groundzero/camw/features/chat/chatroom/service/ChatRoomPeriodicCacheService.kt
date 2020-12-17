package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.core.service.ReadJsonService
import com.groundzero.camw.core.service.WriteJsonService
import com.groundzero.camw.features.chat.chatroom.data.ChatRoomPersistenceRepository
import com.groundzero.camw.features.chat.chatroom.data.ChatRoomRepository
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.springframework.stereotype.Service

@Service
class ChatRoomPeriodicCacheService(
    private val persistenceRepository: ChatRoomPersistenceRepository,
    private val writeJsonService: WriteJsonService,
    private val readJsonService: ReadJsonService,
    private val chatRoomRepository: ChatRoomRepository
) {

    fun storeMessagesFromMemoryToJsonFilePeriodically() {
        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                delay(TIME_TILL_NEXT_CACHE_IN_MILLIS)
                writeJsonService.write(CACHED_MESSAGES_FILE_NAME, persistenceRepository.retrieveMessagesFromMemory())
            }
        }
    }

    fun retrieveMessagesFromJsonFileAndLoadIntoMemory() {
        val messages =
            readJsonService.read<Map<String, MutableList<ChatRoomMessageResponse>>>(CACHED_MESSAGES_FILE_NAME)
        messages?.let {
            chatRoomRepository.retrieveMessagesFromJsonStorage(messages)
        }
    }

    companion object {
        private const val TIME_TILL_NEXT_CACHE_IN_MILLIS = 300_000L
        const val CACHED_MESSAGES_FILE_NAME = "cached-chat-messages"
    }
}