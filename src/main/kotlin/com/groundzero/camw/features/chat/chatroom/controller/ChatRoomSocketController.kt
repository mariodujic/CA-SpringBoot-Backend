package com.groundzero.camw.features.chat.chatroom.controller

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessage
import com.groundzero.camw.features.chat.chatroom.service.ChatRoomMessagesService
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatRoomSocketController(private val chatRoomService: ChatRoomMessagesService) {

    @MessageMapping("/send/{itemId}")
    @SendTo("/room/{itemId}")
    fun echoRoomMessage(
        @DestinationVariable(value = "itemId") roomId: String,
        messageRequest: ChatRoomMessageRequest
    ): List<ChatRoomMessage> {
        chatRoomService.handleMessage(roomId, messageRequest)
        return chatRoomService.getMessagesPerRoomId(roomId = roomId)
    }
}