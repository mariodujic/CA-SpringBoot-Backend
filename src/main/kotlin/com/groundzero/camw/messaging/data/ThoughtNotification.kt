package com.groundzero.camw.messaging.data

data class ThoughtNotification(
        val notificationType: Int? = null,
        val author: String? = null,
        val date: String? = null,
        val image: String? = null,
        val text: String? = null,
        val title: String? = null,
        val itemId: String? = null
)