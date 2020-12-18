package com.groundzero.camw.features.chat.chatroom.data

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse

interface ChatRoomPersistenceRepository {
    fun retrieveAllMessagesFromJsonStorage(): Map<String, List<ChatRoomMessageResponse>>
    fun retrieveAllMessagesFromMemory(): Map<String, List<ChatRoomMessageResponse>>
    fun setMessagesFromJsonStorageToMemory(roomMessagesMap: Map<String, List<ChatRoomMessageResponse>>)
}