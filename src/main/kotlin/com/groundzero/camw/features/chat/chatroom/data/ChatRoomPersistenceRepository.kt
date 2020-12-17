package com.groundzero.camw.features.chat.chatroom.data

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse

interface ChatRoomPersistenceRepository {
    fun retrieveMessagesFromMemory(): MutableMap<String, MutableList<ChatRoomMessageResponse>>
    fun retrieveMessagesFromJsonStorage()
}