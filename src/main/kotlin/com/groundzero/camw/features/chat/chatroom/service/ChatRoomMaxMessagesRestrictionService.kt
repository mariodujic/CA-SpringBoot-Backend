package com.groundzero.camw.features.chat.chatroom.service

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessage

interface ChatRoomMaxMessagesRestrictionService {
    operator fun invoke(messages: List<ChatRoomMessage>): MutableList<ChatRoomMessage>
}