package com.groundzero.camw.features.chat.chatroom.service

import com.google.firebase.database.DataSnapshot
import com.groundzero.camw.core.service.RealtimeDatabaseService
import com.groundzero.camw.features.chat.chatroom.data.ChatRoomMessages
import com.groundzero.camw.utils.getSnapshotValue
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ChatRoomPersistentStorageService(private val realtimeDatabaseService: RealtimeDatabaseService) {

    @Value("\${messages.database.collection.path}")
    private lateinit var collectionPath: String

    suspend fun getMessagesFromPersistentStorage(): DataSnapshot =
        realtimeDatabaseService.getData(collectionPath).getSnapshotValue()

    fun writeMessagesToPersistentStorage(roomMessagesList: List<ChatRoomMessages>) {
        realtimeDatabaseService.setData(collectionPath, roomMessagesList).get()
    }
}