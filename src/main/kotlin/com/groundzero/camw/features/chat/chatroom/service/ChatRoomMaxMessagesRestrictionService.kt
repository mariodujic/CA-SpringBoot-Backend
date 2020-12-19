package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import org.springframework.stereotype.Service

@Service
class ChatRoomMaxMessagesRestrictionService {

    operator fun invoke(messages: List<ChatRoomMessageResponse>): MutableList<ChatRoomMessageResponse> {
        return messages.toMutableList().apply {
            if (messages.size > MAX_MESSAGE_COUNT) removeAt(0)
        }
    }

    private companion object {
        const val MAX_MESSAGE_COUNT = 100
    }
}