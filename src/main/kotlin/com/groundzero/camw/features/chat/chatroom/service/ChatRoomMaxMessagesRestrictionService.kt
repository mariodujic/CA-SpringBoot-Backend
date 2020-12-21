package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse

interface ChatRoomMaxMessagesRestrictionService {
    operator fun invoke(messages: List<ChatRoomMessageResponse>): MutableList<ChatRoomMessageResponse>
}