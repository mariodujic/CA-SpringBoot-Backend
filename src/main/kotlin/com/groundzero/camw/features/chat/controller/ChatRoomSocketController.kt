package com.groundzero.camw.features.chat.controller

import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatRoomSocketController {

    @MessageMapping("/send/{itemId}")
    @SendTo("/room/{itemId}")
    fun echoRoomMessage(@DestinationVariable(value = "itemId") destination: String, message: String?): String? {
        return message
    }
}