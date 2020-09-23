package com.groundzero.camw.core.service

import com.google.cloud.firestore.QueryDocumentSnapshot
import com.groundzero.camw.core.data.FirestoreProvider
import org.springframework.stereotype.Component

@Component
class FirestoreService(private val firestoreProvider: FirestoreProvider) {

    fun getDocuments(collectionKey: String): MutableList<QueryDocumentSnapshot> =
            firestoreProvider.firestore.collection(collectionKey).get().get().documents
}