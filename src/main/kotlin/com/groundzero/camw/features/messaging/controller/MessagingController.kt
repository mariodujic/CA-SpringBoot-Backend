package com.groundzero.camw.features.messaging.controller

import com.groundzero.camw.core.network.NetworkResponse
import com.groundzero.camw.features.messaging.data.NotificationRequest
import com.groundzero.camw.features.authentication.AuthenticationService
import com.groundzero.camw.features.messaging.service.MessagingService
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
    fun sendMessage(@RequestBody notificationRequest: NotificationRequest): NetworkResponse {
        val verified = authenticationService.authenticateUser(notificationRequest.email)

        return if (verified) {
            messagingService.sendMessage(notificationRequest)
            NetworkResponse.Success<Nothing>(200, "Message sent successfully", emptyList())
        } else {
            NetworkResponse.Error(401, "Unauthorized user")
        }
    }
}