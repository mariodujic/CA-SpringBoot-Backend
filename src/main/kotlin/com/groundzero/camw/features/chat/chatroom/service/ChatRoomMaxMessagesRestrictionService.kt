package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ChatRoomMaxMessagesRestrictionService {

    @Value("\${messages.database.max.storage.count}")
    private var maxMessagesCount: Long? = null

    operator fun invoke(messages: List<ChatRoomMessageResponse>): MutableList<ChatRoomMessageResponse> {
        if (maxMessagesCount == null) throw IllegalStateException("Value is required")
        return messages.toMutableList().apply {
            if (messages.size > maxMessagesCount!!) removeAt(0)
        }
    }
}