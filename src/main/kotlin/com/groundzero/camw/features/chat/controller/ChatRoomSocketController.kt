package com.groundzero.camw.features.chat.controller

import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatRoomSocketController {

    @MessageMapping("/message")
    @SendTo("/room/messages")
    fun echoRoomMessage(message: String?): String? {
        return message
    }
}