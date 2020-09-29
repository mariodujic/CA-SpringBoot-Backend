package com.groundzero.camw.messaging.controller

import com.groundzero.camw.core.network.NetworkResponse
import com.groundzero.camw.messaging.data.NotificationMessage
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
    fun sendMessage(@RequestBody notificationMessage: NotificationMessage): NetworkResponse {
        val verified = authenticationService.authenticateUser(notificationMessage.email)

        return if (verified) {
            messagingService.sendMessage(notificationMessage)
            NetworkResponse.Success<Nothing>(200, "Message sent successfully", emptyList())
        } else {
            NetworkResponse.Error(401, "Unauthorized user")
        }
    }
}