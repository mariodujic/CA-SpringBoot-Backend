package com.groundzero.camw.core.repository

import com.google.cloud.firestore.WriteResult
import com.groundzero.camw.core.data.NetworkModel
import com.groundzero.camw.core.service.FirestoreService
import org.springframework.stereotype.Component

@Component
class FirestoreRepositoryImpl(private val firestoreService: FirestoreService) : FirestoreRepository {
    override fun addDocument(item: NetworkModel, collectionKey: String): WriteResult =
            firestoreService.addDocument(item, collectionKey)

    override fun removeDocument(itemId: String, collectionKey: String): WriteResult =
            firestoreService.removeDocument(itemId, collectionKey)
}