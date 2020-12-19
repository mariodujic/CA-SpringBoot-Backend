package com.groundzero.camw.features.chat.chatroom.data

import com.groundzero.camw.features.chat.chatroom.mapper.DataSnapshotToMapRoomMessages
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import com.groundzero.camw.features.chat.chatroom.service.ChatRoomPersistentStorageService
import com.groundzero.camw.features.chat.chatroom.service.ChatRoomMemoryStorageService
import org.springframework.stereotype.Repository

@Repository
class ChatRoomRepository(
    private val chatRoomPersistentStorageService: ChatRoomPersistentStorageService,
    private val chatRoomMemoryStorageService: ChatRoomMemoryStorageService,
    private val mapper: DataSnapshotToMapRoomMessages
) : ChatRoomPersistenceRepository, ChatRoomMessagesRepository {

    override fun insertMessageToMemory(roomId: String, request: ChatRoomMessageRequest) = chatRoomMemoryStorageService.storeMessage(roomId, request)
    override fun getMessagesPerRoomIdFromMemory(roomId: String) = chatRoomMemoryStorageService.getMessagesPerRoomId(roomId)

    override suspend fun retrieveMessagesFromPersistentStorage() = mapper.map(chatRoomPersistentStorageService.getMessagesFromPersistentStorage())
    override fun insertMessagesToPersistentStorage(messages: Map<String, List<ChatRoomMessageResponse>>) { chatRoomPersistentStorageService.writeMessagesToPersistentStorage(messages) }
    override fun retrieveMessagesFromMemory(): Map<String, List<ChatRoomMessageResponse>> = chatRoomMemoryStorageService.getAllMemoryMessages()
    override fun insertMessagesToMemory(roomMessagesMap: Map<String, List<ChatRoomMessageResponse>>) =
        chatRoomMemoryStorageService.setMessagesFromJsonStorage(roomMessagesMap)
}