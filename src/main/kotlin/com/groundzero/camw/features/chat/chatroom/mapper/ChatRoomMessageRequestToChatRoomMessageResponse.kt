package com.groundzero.camw.features.chat.chatroom.mapper

import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import com.groundzero.camw.utils.DateUtils
import org.springframework.stereotype.Component
import java.util.*

@Component
class ChatRoomMessageRequestToChatRoomMessageResponse : Mapper<ChatRoomMessageRequest, ChatRoomMessageResponse> {

    override fun map(data: ChatRoomMessageRequest): ChatRoomMessageResponse = ChatRoomMessageResponse(
        messageId = data.messageId,
        userId = data.userId,
        message = data.message,
        time = DateUtils.currentDate(Date())
    )
}