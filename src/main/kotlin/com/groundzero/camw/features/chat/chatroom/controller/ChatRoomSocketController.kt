package com.groundzero.camw.features.chat.chatroom.controller

import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatRoomSocketController {

    private val map = mutableMapOf<String, MutableList<String>>()

    @MessageMapping("/send/{itemId}")
    @SendTo("/room/{itemId}")
    fun echoRoomMessage(@DestinationVariable(value = "itemId") destination: String, message: String): MutableList<String>? {

        val messages: MutableList<String>
        if (destination == message) {
            return map[destination]
        }
        if (map.containsKey(destination)) {
            messages = map[destination]!!
            messages.add(message)
        } else {
            messages = mutableListOf(message)
        }

        map[destination] = messages

        return map[destination]
    }
}