package com.groundzero.camw.core.service

import com.google.cloud.firestore.QueryDocumentSnapshot
import com.groundzero.camw.core.data.FirebaseDatabase
import org.springframework.stereotype.Component

@Component
class FirestoreService(private val firebaseDatabase: FirebaseDatabase) {

    fun getDocuments(collectionKey: String): MutableList<QueryDocumentSnapshot> =
            firebaseDatabase.firestore.collection(collectionKey).get().get().documents
}