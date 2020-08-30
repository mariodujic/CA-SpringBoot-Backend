package com.groundzero.camw.data

import com.google.cloud.firestore.QueryDocumentSnapshot
import org.springframework.stereotype.Component

/**
 * 'inline' modifier is not allowed on virtual members
 */
@Component
class ReadNetworkService(
        val firestoreService: FirestoreService,
        firestoreMapper: FirestoreMapper
) : ReadNetworkServiceImpl(firestoreService, firestoreMapper)

open class ReadNetworkServiceImpl(
        private val firestoreService: FirestoreService,
        private val firestoreMapper: FirestoreMapper
) {

    internal inline fun <reified T> readDatabase(collectionKey: String): List<T>? = firestoreMapper.getDataAsList(getCollection(collectionKey))
    private fun getCollection(collectionKey: String): List<QueryDocumentSnapshot> {
        return firestoreService.getDocuments(collectionKey)
    }
}
