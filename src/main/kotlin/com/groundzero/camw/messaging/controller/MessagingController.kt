package com.groundzero.camw.messaging.controller

import com.groundzero.camw.core.network.NetworkResponse
import com.groundzero.camw.messaging.data.Message
import com.groundzero.camw.messaging.repository.MessagingRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/message")
class MessagingController(private val repository: MessagingRepository) {

    @PostMapping("/send")
    fun sendMessage(@RequestBody message: Message): NetworkResponse {
        val verified = repository.authenticateUser(message.email)

        return if (verified) {
            NetworkResponse.Success<Nothing>(200, "Succesfully authenticated", emptyList())
        } else {
            NetworkResponse.Error(401, "Unauthorized user")
        }
    }
}