package com.groundzero.camw.features.messaging.data

data class UpdateNotificationResponse(
        val notificationType: Int,
        val title: String,
        val text: String,
        val url: String,
        val version: Float
)