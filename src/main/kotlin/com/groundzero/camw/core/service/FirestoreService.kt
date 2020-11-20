package com.groundzero.camw.core.service

import com.google.cloud.firestore.QueryDocumentSnapshot
import com.google.cloud.firestore.WriteResult
import com.groundzero.camw.core.data.NetworkModel
import com.groundzero.camw.core.data.providers.FirestoreProvider
import org.springframework.stereotype.Component

@Component
class FirestoreService(private val firestoreProvider: FirestoreProvider) {

    fun getDocuments(collectionKey: String): MutableList<QueryDocumentSnapshot> =
            firestoreProvider.firestore.collection(collectionKey).get().get().documents

    fun addDocument(item: NetworkModel, collectionKey: String): WriteResult =
            firestoreProvider.firestore.collection(collectionKey).document(item.itemId!!).set(item).get()

    fun removeDocument(itemId: String, collectionKey: String): WriteResult =
            firestoreProvider.firestore.collection(collectionKey).document(itemId).delete().get()
}