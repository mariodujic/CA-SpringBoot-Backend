package com.groundzero.camw.messaging.controller

import com.groundzero.camw.core.network.NetworkResponse
import com.groundzero.camw.messaging.data.Message
import com.groundzero.camw.messaging.service.AuthenticationService
import com.groundzero.camw.messaging.service.MessagingService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/message")
class MessagingController(
        private val messagingService: MessagingService,
        private val authenticationService: AuthenticationService
) {

    @PostMapping("/send")
    fun sendMessage(@RequestBody message: Message): NetworkResponse {
        val verified = authenticationService.authenticateUser(message.email)

        return if (verified) {
            // messages is a placeholder
            messagingService.addMessage("messages", message)

            NetworkResponse.Success<Nothing>(200, "Successfully authenticated", emptyList())
        } else {
            NetworkResponse.Error(401, "Unauthorized user")
        }
    }
}