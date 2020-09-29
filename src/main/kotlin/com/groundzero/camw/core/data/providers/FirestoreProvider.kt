package com.groundzero.camw.core.data.providers

import com.google.cloud.firestore.Firestore
import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Component

@Component
class FirestoreProvider {
    val firestore: Firestore = FirestoreClient.getFirestore()
}