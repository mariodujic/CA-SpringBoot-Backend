package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.features.chat.chatroom.data.ChatRoomMessages
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessage
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest

interface ChatRoomMemoryStorageService {
    fun insertMessage(roomId: String, request: ChatRoomMessageRequest)
    fun updateMessage(roomId: String, request: ChatRoomMessageRequest)
    fun deleteMessage(roomId: String, messageId: String)
    fun getMessagesPerRoomId(roomId: String): List<ChatRoomMessage>
    fun getAllMemoryMessages(): List<ChatRoomMessages>
    fun setMessagesFromJsonStorage(roomMessagesList: List<ChatRoomMessages>)
}