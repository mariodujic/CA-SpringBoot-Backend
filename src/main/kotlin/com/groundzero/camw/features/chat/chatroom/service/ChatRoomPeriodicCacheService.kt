package com.groundzero.camw.features.chat.chatroom.service

interface ChatRoomPeriodicCacheService {
    fun retrieveMessagesFromPersistentStorage()
    fun storeMessagesFromMemoryToPersistentStoragePeriodically()
}