package com.groundzero.camw.features.chat.chatroom.data

interface ChatRoomPersistenceRepository {
    suspend fun retrieveMessagesFromPersistentStorage(): List<ChatRoomMessages>
    fun insertMessagesToPersistentStorage(roomMessagesList: List<ChatRoomMessages>)
    fun retrieveMessagesFromMemory(): List<ChatRoomMessages>
    fun insertMessagesToMemory(roomMessagesList: List<ChatRoomMessages>)
}