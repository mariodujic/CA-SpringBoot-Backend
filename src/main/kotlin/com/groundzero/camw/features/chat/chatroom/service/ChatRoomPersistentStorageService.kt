package com.groundzero.camw.features.chat.chatroom.service

import com.google.firebase.database.DataSnapshot
import com.groundzero.camw.features.chat.chatroom.data.ChatRoomMessages

interface ChatRoomPersistentStorageService {
    suspend fun getMessagesFromPersistentStorage(): DataSnapshot
    fun writeMessagesToPersistentStorage(roomMessagesList: List<ChatRoomMessages>)
}