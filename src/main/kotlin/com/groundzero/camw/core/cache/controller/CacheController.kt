package com.groundzero.camw.core.cache.controller

import com.groundzero.camw.core.cache.service.CacheService
import com.groundzero.camw.features.chat.chatroom.service.ChatRoomPeriodicCacheService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CacheController(
    private val cacheService: CacheService,
    private val chatRoomPeriodicCacheService: ChatRoomPeriodicCacheService
) : CommandLineRunner {

    override fun run(vararg args: String?) {/*
        cacheService.updateQuizzes()
        cacheService.updatePrayers()
        cacheService.updateThoughts()
        cacheService.updateSaints()
        cacheService.updateInformation()
        cacheService.updateAdConfig()
        cacheService.updateUserReports()*/
        cacheService.updateChatRooms()
        /**
         * On server start, messages are retrieved from database json file and injected into memory for runtime usage.
         */
        chatRoomPeriodicCacheService.retrieveAllMessagesFromJsonStorage()
        /**
         * Storing messages periodically to keep them persistent when server goes offline.
         */
        chatRoomPeriodicCacheService.storeMessagesFromMemoryToJsonFilePeriodically()
    }
}