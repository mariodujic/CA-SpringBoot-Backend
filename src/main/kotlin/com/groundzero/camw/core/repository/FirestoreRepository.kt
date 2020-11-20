package com.groundzero.camw.core.repository

import com.google.cloud.firestore.WriteResult
import com.groundzero.camw.core.data.NetworkModel

interface FirestoreRepository {
    fun addDocument(item: NetworkModel, collectionKey: String): WriteResult
    fun removeDocument(itemId: String, collectionKey: String): WriteResult
}