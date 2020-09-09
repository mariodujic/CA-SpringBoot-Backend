package com.groundzero.camw.service

import com.google.cloud.firestore.QueryDocumentSnapshot
import com.groundzero.camw.data.FirestoreMapper
import org.springframework.stereotype.Component

@Component
@Suppress("declaration_cant_be_inlined")
class ReadNetworkService(
        private val firestoreService: FirestoreService,
        private val firestoreMapper: FirestoreMapper
) {
    internal inline fun <reified T> readDatabase(collectionKey: String): List<T>? = firestoreMapper.getDataAsList(getCollection(collectionKey))
    private fun getCollection(collectionKey: String): List<QueryDocumentSnapshot> {
        return firestoreService.getDocuments(collectionKey)
    }
}