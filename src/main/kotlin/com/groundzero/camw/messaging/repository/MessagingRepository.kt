package com.groundzero.camw.messaging.repository

import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.groundzero.camw.core.data.FirestoreProvider
import com.groundzero.camw.messaging.data.Message
import org.springframework.stereotype.Component

@Component
class MessagingRepository(
        private val firestoreProvider: FirestoreProvider,
        private val messageToThoughtMapper: MessageToThoughtMapper
) {

    fun addMessage(collectionKey: String, message: Message): ApiFuture<DocumentReference> =
            firestoreProvider.firestore.collection(collectionKey).add(messageToThoughtMapper.map(message))
}