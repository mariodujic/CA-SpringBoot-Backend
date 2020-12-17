package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.core.service.WriteJsonService
import com.groundzero.camw.features.chat.chatroom.data.ChatRoomPersistenceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.springframework.stereotype.Service

@Service
class ChatRoomPeriodicCacheService(
    private val persistenceRepository: ChatRoomPersistenceRepository,
    private val writeJsonService: WriteJsonService,
    private val chatRoomPersistenceRepository: ChatRoomPersistenceRepository
) {

    fun retrieveMessagesFromJsonFileAndLoadIntoMemory() =
        chatRoomPersistenceRepository.retrieveMessagesFromJsonStorage()

    fun storeMessagesFromMemoryToJsonFilePeriodically() {
        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                delay(TIME_TILL_NEXT_CACHE_IN_MILLIS)
                writeJsonService.write(CACHED_MESSAGES_FILE_NAME, persistenceRepository.retrieveMessagesFromMemory())
            }
        }
    }

    companion object {
        private const val TIME_TILL_NEXT_CACHE_IN_MILLIS = 300_000L
        const val CACHED_MESSAGES_FILE_NAME = "cached-chat-messages"
    }
}