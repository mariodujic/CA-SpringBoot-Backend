package com.groundzero.camw.features.chat.chatroom.mapper

import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessage
import com.groundzero.camw.utils.DateUtils
import org.springframework.stereotype.Component
import java.util.*

@Component
class ChatRoomRequestToChatRoomResponse : Mapper<ChatRoomMessageRequest, ChatRoomMessage> {

    override fun map(data: ChatRoomMessageRequest): ChatRoomMessage = ChatRoomMessage(
        messageId = data.messageId,
        userId = data.userId,
        message = data.message,
        time = DateUtils.currentDate(Date())
    )
}