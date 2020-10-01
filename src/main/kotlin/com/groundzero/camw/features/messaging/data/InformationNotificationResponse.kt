package com.groundzero.camw.features.messaging.data

data class InformationNotificationResponse(
        val notificationType: Int? = null,
        val title: String? = null,
        val subtitle: String? = null,
        val text: String? = null,
        val url: String? = null
)