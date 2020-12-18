package com.groundzero.camw.features.chat.chatroom.data

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import com.groundzero.camw.features.chat.chatroom.service.ChatRoomJsonStorageService
import com.groundzero.camw.features.chat.chatroom.service.ChatRoomMemoryStorageService
import org.springframework.stereotype.Repository

@Repository
class ChatRoomRepository(
    private val chatRoomJsonStorageService: ChatRoomJsonStorageService,
    private val chatRoomMemoryStorageService: ChatRoomMemoryStorageService
) : ChatRoomPersistenceRepository, ChatRoomMessagesRepository {

    override fun insertMessage(roomId: String, request: ChatRoomMessageRequest) = chatRoomMemoryStorageService.storeMessage(roomId, request)
    override fun getMessagesPerRoomIdFromMemory(roomId: String) = chatRoomMemoryStorageService.getMessages(roomId)
    override fun retrieveAllMessagesFromJsonStorage(): Map<String, List<ChatRoomMessageResponse>> = chatRoomJsonStorageService.getAllMessagesFromJsonStorage()
    override fun retrieveAllMessagesFromMemory(): Map<String, List<ChatRoomMessageResponse>> = chatRoomMemoryStorageService.getAllMemoryMessages()
    override fun setMessagesFromJsonStorageToMemory(roomMessagesMap: Map<String, List<ChatRoomMessageResponse>>) =
        chatRoomMemoryStorageService.setJsonStorageMessages(roomMessagesMap)
}