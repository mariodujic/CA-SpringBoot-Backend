package com.groundzero.camw.features.chat.chatroom.mapper

import com.groundzero.camw.core.data.NullableMapper
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import org.springframework.stereotype.Component

@Component
class ChatRoomMessageRequestToMessageType : NullableMapper<ChatRoomMessageRequest, ChatRoomMessageRequest.MessageType> {
    override fun map(data: ChatRoomMessageRequest) = ChatRoomMessageRequest.MessageType.getType(data.messageType)
}