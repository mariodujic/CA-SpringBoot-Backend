package com.groundzero.camw.features.chat.chatroom.service

import com.google.firebase.database.DataSnapshot
import com.groundzero.camw.core.service.RealtimeDatabaseService
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import com.groundzero.camw.utils.getSnapshotValue
import org.springframework.stereotype.Service

@Service
class ChatRoomPersistentStorageService(private val realtimeDatabaseService: RealtimeDatabaseService) {

    suspend fun getMessagesFromPersistentStorage(): DataSnapshot =
        realtimeDatabaseService.getData(CACHED_MESSAGES_FILE_NAME).getSnapshotValue()

    fun writeMessagesToPersistentStorage(messages: Map<String, List<ChatRoomMessageResponse>>) {
        realtimeDatabaseService.setData(CACHED_MESSAGES_FILE_NAME, messages).get()
    }

    companion object {
        const val CACHED_MESSAGES_FILE_NAME = "chat-room-messages"
    }
}