package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessage
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ChatRoomMaxMessagesRestrictionServiceImpl : ChatRoomMaxMessagesRestrictionService {

    @Value("\${messages.database.max.storage.count}")
    private var maxMessagesCount: Long? = null

    override operator fun invoke(messages: List<ChatRoomMessage>): MutableList<ChatRoomMessage> {
        if (maxMessagesCount == null) throw IllegalStateException("Value is required")
        return messages.toMutableList().apply {
            if (messages.size > maxMessagesCount!!) removeAt(0)
        }
    }
}