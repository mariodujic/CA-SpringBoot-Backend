package com.groundzero.camw.features.messaging.data

data class NotificationRequest(
        val itemId: String,
        val email: String,
        val author: String,
        val topic: String,
        val image: String = "",
        val notificationType: Int,
        val title: String,
        val text: String,
        val url: String = "",
        val version: Float = 0f
)