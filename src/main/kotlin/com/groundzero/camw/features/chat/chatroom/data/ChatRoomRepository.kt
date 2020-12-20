package com.groundzero.camw.features.chat.chatroom.data

import com.groundzero.camw.features.chat.chatroom.mapper.DataSnapshotToListChatRoomMessagesResponse
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.service.ChatRoomMemoryStorageService
import com.groundzero.camw.features.chat.chatroom.service.ChatRoomPersistentStorageService
import org.springframework.stereotype.Repository

@Repository
class ChatRoomRepository(
    private val chatRoomPersistentStorageService: ChatRoomPersistentStorageService,
    private val chatRoomMemoryStorageService: ChatRoomMemoryStorageService,
    private val mapper: DataSnapshotToListChatRoomMessagesResponse
) : ChatRoomPersistenceRepository, ChatRoomMessagesRepository {

    override fun handleMessage(roomId: String, request: ChatRoomMessageRequest) =
        chatRoomMemoryStorageService.handleMessage(roomId, request)

    override fun getMessagesPerRoomIdFromMemory(roomId: String) =
        chatRoomMemoryStorageService.getMessagesPerRoomId(roomId)

    override suspend fun retrieveMessagesFromPersistentStorage() =
        mapper.map(chatRoomPersistentStorageService.getMessagesFromPersistentStorage())

    override fun insertMessagesToPersistentStorage(roomMessagesList: List<ChatRoomMessages>) {
        chatRoomPersistentStorageService.writeMessagesToPersistentStorage(roomMessagesList)
    }

    override fun retrieveMessagesFromMemory(): List<ChatRoomMessages> =
        chatRoomMemoryStorageService.getAllMemoryMessages()

    override fun insertMessagesToMemory(roomMessagesList: List<ChatRoomMessages>) =
        chatRoomMemoryStorageService.setMessagesFromJsonStorage(roomMessagesList)
}