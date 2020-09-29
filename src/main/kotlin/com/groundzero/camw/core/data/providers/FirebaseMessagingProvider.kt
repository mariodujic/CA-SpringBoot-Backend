package com.groundzero.camw.core.data.providers

import com.google.firebase.messaging.FirebaseMessaging
import org.springframework.stereotype.Component

@Component
class FirebaseMessagingProvider {
    val messaging: FirebaseMessaging = FirebaseMessaging.getInstance()
}