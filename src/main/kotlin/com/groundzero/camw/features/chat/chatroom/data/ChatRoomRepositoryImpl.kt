package com.groundzero.camw.features.chat.chatroom.data

import com.groundzero.camw.features.chat.chatroom.mapper.DataSnapshotToListChatRoomMessages
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.service.ChatRoomMemoryStorageService
import com.groundzero.camw.features.chat.chatroom.service.ChatRoomPersistentStorageService
import org.springframework.stereotype.Repository

@Repository
class ChatRoomRepositoryImpl(
    private val chatRoomPersistentStorageService: ChatRoomPersistentStorageService,
    private val chatRoomMemoryStorageService: ChatRoomMemoryStorageService,
    private val mapper: DataSnapshotToListChatRoomMessages
) : ChatRoomPersistenceRepository, ChatRoomMessagesRepository {

    override fun insertMessage(roomId: String, request: ChatRoomMessageRequest) =
        chatRoomMemoryStorageService.insertMessage(roomId, request)

    override fun updateMessage(roomId: String, request: ChatRoomMessageRequest) =
        chatRoomMemoryStorageService.updateMessage(roomId, request)

    override fun deleteMessage(roomId: String, messageId: String) =
        chatRoomMemoryStorageService.deleteMessage(roomId, messageId)

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