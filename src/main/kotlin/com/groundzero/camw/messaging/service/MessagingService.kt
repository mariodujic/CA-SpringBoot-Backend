package com.groundzero.camw.messaging.service

import com.groundzero.camw.messaging.data.Message
import com.groundzero.camw.messaging.repository.MessagingRepository
import org.springframework.stereotype.Component

@Component
class MessagingService(private val repository: MessagingRepository) {
    fun addMessage(collectionKey: String, item: Message) = repository.addMessage(collectionKey, item)
}