package com.groundzero.camw.features.messaging.data

data class NotificationRequest(
        val itemId: String,
        val author: String,
        val image: String = "",
        val notificationType: Int,
        val title: String,
        val text: String,
        val url: String = "",
        val version: Float = 0f
)