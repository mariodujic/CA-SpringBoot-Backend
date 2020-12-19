package com.groundzero.camw.features.chat.chatroom.data

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse

interface ChatRoomPersistenceRepository {
    suspend fun retrieveMessagesFromPersistentStorage(): Map<String, List<ChatRoomMessageResponse>>
    fun insertMessagesToPersistentStorage(messages: Map<String, List<ChatRoomMessageResponse>>)
    fun retrieveMessagesFromMemory(): Map<String, List<ChatRoomMessageResponse>>
    fun insertMessagesToMemory(roomMessagesMap: Map<String, List<ChatRoomMessageResponse>>)
}