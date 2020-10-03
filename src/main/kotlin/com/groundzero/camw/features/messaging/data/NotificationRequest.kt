package com.groundzero.camw.features.messaging.data

import java.util.*

data class NotificationRequest(
        val id: String = UUID.randomUUID().toString(),
        val email: String,
        val author: String,
        val topic: String,
        val image: String = "",
        val notificationType: Int,
        val title: String,
        val subtitle: String = "",
        val text: String,
        val url: String = "",
        val version: Float = 0f
)