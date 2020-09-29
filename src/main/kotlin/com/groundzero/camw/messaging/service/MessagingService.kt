package com.groundzero.camw.messaging.service

import com.google.firebase.database.DatabaseReference
import com.google.firebase.messaging.Message
import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.core.data.NullableMapper
import com.groundzero.camw.core.data.providers.FirebaseMessagingProvider
import com.groundzero.camw.messaging.data.MessageType
import com.groundzero.camw.messaging.data.NotificationMessage
import com.groundzero.camw.messaging.repository.MessagingRepository
import com.groundzero.camw.thoughts.data.Thought
import com.groundzero.camw.utils.asMap
import org.springframework.stereotype.Component

@Component
class MessagingService(
        private val messagingProvider: FirebaseMessagingProvider,
        private val repository: MessagingRepository,
        private val notificationMessageToThoughtMapper: Mapper<NotificationMessage, Thought>,
        private val notificationMessageToTypeMapper: NullableMapper<NotificationMessage, MessageType>,
) {
    /**
     * TODO implement more notification types
     */
    fun sendMessage(item: NotificationMessage) {
        val type = notificationMessageToTypeMapper.map(item)
        when (type) {
            MessageType.THOUGHT -> sendThoughtMessage(item.topic, notificationMessageToThoughtMapper.map(item))
        }
    }
    /**
     * When user opens a thought type notification, content will be read from the realtime database.
     */
    private fun sendThoughtMessage(collectionKey: String, thought: Thought) {
        repository.updateRealTimeDatabaseThought(collectionKey, thought, realtimeThoughtListener {
            /**
             * Notification send to a user device.
             */
            sendNotification(topic = collectionKey, thought)
            /**
             * Adding thought to an origin database. This database is a data backup. If middleware stops working
             * users will be redirected to get data from the Firestore.
             */
            repository.addMessageToFirestore(collectionKey, thought)
        })
    }

    private fun realtimeThoughtListener(action: () -> Unit) =
            DatabaseReference.CompletionListener { _, reference -> if (reference != null) action() }

    private fun sendNotification(topic: String, thought: Thought) {
        val message = Message.builder()
                .putAllData(thought.asMap())
                .setTopic(topic)
                .build()
        messagingProvider.messaging.send(message)
    }
}