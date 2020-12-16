package com.groundzero.camw.features.chat.chatroom.controller

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import com.groundzero.camw.features.chat.chatroom.service.ChatRoomService
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatRoomSocketController(private val chatRoomService: ChatRoomService) {

    @MessageMapping("/send/{itemId}")
    @SendTo("/room/{itemId}")
    fun echoRoomMessage(
        @DestinationVariable(value = "itemId") destination: String,
        messageRequest: ChatRoomMessageRequest
    ): MutableList<ChatRoomMessageResponse>? = chatRoomService.getMessagesPerRoomId(destination, messageRequest)
}