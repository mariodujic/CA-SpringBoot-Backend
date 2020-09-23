package com.groundzero.camw.messaging.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/message")
class MessagingController {

    @PostMapping("/send")
    fun sendMessage(@RequestBody requestBody: RequestBody) {
        println("Send message request received: $requestBody")
    }
}