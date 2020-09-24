package com.groundzero.camw.messaging.repository

import com.groundzero.camw.messaging.service.MessagingService
import org.springframework.stereotype.Component

@Component
class MessagingRepository(private val service: MessagingService) {
    fun authenticateUser(email: String) = service.authenticateUser(email)
}