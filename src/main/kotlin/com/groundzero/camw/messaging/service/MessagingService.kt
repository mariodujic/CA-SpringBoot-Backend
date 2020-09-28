package com.groundzero.camw.messaging.service

import com.google.firebase.auth.FirebaseAuthException
import com.groundzero.camw.messaging.data.Message
import com.groundzero.camw.messaging.repository.MessagingRepository
import org.springframework.stereotype.Component

@Component
class MessagingService(
        private val repository: MessagingRepository
) {
    fun authenticateUser(email: String) = try {
        repository.authenticateUser(email)
        true
    } catch (e: FirebaseAuthException) {
        false
    }

    fun addMessage(collectionKey: String, item: Message) = repository.addMessage(collectionKey, item)
}