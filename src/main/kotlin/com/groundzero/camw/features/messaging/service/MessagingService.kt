package com.groundzero.camw.features.messaging.service

import com.google.firebase.database.DatabaseReference
import com.google.firebase.messaging.Message
import com.groundzero.camw.core.base.BaseRepository
import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.core.data.NullableMapper
import com.groundzero.camw.core.data.providers.FirebaseMessagingProvider
import com.groundzero.camw.features.messaging.data.*
import com.groundzero.camw.features.messaging.repository.MessagingRepository
import com.groundzero.camw.features.thoughts.constants.ThoughtDataType
import com.groundzero.camw.features.thoughts.data.Thought
import com.groundzero.camw.utils.asMap
import org.springframework.stereotype.Component

@Component
class MessagingService(
        private val messagingProvider: FirebaseMessagingProvider,
        private val repository: MessagingRepository,
        private val baseRepository: BaseRepository<Thought>,
        private val notificationRequestToThoughtDomainMapper: Mapper<NotificationRequest, Thought>,
        private val notificationRequestToInformationNotificationResponseMapper: Mapper<NotificationRequest, InformationNotificationResponse>,
        private val notificationRequestToUpdateNotificationResponseMapper: Mapper<NotificationRequest, UpdateNotificationResponse>,
        private val thoughtDomainToThoughtNotificationResponseMapper: Mapper<Thought, ThoughtNotificationResponse>,
        private val notificationRequestToTypeMapper: NullableMapper<NotificationRequest, MessageType>,
) {

    fun sendMessage(item: NotificationRequest, dataType: DataType) {
        val type = notificationRequestToTypeMapper.map(item)
        when (type) {
            MessageType.THOUGHT -> sendThoughtMessage(dataType, notificationRequestToThoughtDomainMapper.map(item))
            MessageType.INFORMATION -> sendMessage(dataType.path, notificationRequestToInformationNotificationResponseMapper.map(item))
            MessageType.UPDATE -> sendMessage(dataType.path, notificationRequestToUpdateNotificationResponseMapper.map(item))
        }
    }

    /**
     * When user opens a thought type notification, content will be read from the realtime database.
     */
    private fun sendThoughtMessage(dataType: DataType, thought: Thought) {
        repository.updateRealTimeDatabaseThought(dataType.path, thought, realtimeThoughtListener {
            /**
             * Notification send to a user device.
             */
            sendThoughtNotification(topic = dataType.path, thought)
            /**
             * Adding thought to an origin database. This database is a data backup. If middleware stops working
             * users will be redirected to get data from the Firestore.
             */
            repository.addMessageToFirestore(dataType.path, thought)
            /**
             * Adding thought to a local json storage
             */
            baseRepository.addItem(thought, dataType)
        })
    }

    private fun realtimeThoughtListener(action: () -> Unit) =
            DatabaseReference.CompletionListener { _, reference -> if (reference != null) action() }

    private fun sendThoughtNotification(topic: String, thought: Thought) {
        val thoughtNotification = thoughtDomainToThoughtNotificationResponseMapper.map(thought)
        sendMessage(topic, thoughtNotification)
    }

    private inline fun <reified T> sendMessage(topic: String, data: T) =
            messagingProvider.messaging.send(getMessage(topic, data))

    private inline fun <reified T> getMessage(topic: String, data: T) = Message.builder()
            .putAllData(data!!.asMap())
            .setTopic(topic)
            .build()
}