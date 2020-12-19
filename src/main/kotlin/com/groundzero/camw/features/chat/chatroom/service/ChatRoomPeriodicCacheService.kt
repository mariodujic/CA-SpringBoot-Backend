package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.features.chat.chatroom.data.ChatRoomPersistenceRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ChatRoomPeriodicCacheService(private val chatRoomPersistenceRepository: ChatRoomPersistenceRepository) {

    @Value("\${messages.database.periodic.cache.in.millis}")
    private var periodicCacheInMillis: Long? = null

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
        if (periodicCacheInMillis == null) throw IllegalStateException("Value is required")
        CoroutineScope(IO).launch {
            while (true) {
                delay(periodicCacheInMillis!!)
                chatRoomPersistenceRepository.insertMessagesToPersistentStorage(
                    chatRoomPersistenceRepository.retrieveMessagesFromMemory()
                )
            }
        }
    }
}