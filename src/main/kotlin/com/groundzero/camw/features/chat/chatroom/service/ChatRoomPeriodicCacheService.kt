package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.features.chat.chatroom.data.ChatRoomPersistenceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.springframework.stereotype.Service

@Service
class ChatRoomPeriodicCacheService(private val chatRoomPersistenceRepository: ChatRoomPersistenceRepository) {

    /**
     * Fetching persistent messages on server start.
     */
    fun retrieveMessagesFromPersistentStorage() {
        CoroutineScope(IO).launch {
            chatRoomPersistenceRepository.retrieveMessagesFromPersistentStorage().let {
                chatRoomPersistenceRepository.insertMessagesToMemory(it)
            }
        }
    }

    /**
     * Periodically persisting messages in case of server restart.
     */
    fun storeMessagesFromMemoryToPersistentStoragePeriodically() {
        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                delay(TIME_TILL_NEXT_CACHE_IN_MILLIS)
                chatRoomPersistenceRepository.insertMessagesToPersistentStorage(
                    chatRoomPersistenceRepository.retrieveMessagesFromMemory()
                )
            }
        }
    }

    companion object {
        private const val TIME_TILL_NEXT_CACHE_IN_MILLIS = 300_000L // 5 min
    }
}