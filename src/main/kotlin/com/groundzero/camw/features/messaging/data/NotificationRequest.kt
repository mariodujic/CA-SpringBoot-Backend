package com.groundzero.camw.features.messaging.data

import java.util.*

data class NotificationRequest(
        val id: String = UUID.randomUUID().toString(),
        val email: String,
        val author: String,
        val topic: String,
        val image: String = "",
        val messageType: Int,
        val title: String,
        val text: String
)