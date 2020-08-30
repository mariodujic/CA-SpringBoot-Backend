package com.groundzero.camw.data

import com.google.cloud.firestore.QueryDocumentSnapshot
import org.springframework.stereotype.Component

@Component
class FirestoreService(private val firebaseDatabase: FirebaseDatabase) {

    fun getDocuments(collectionKey: String): MutableList<QueryDocumentSnapshot> =
            firebaseDatabase.firestore.collection(collectionKey).get().get().documents
}