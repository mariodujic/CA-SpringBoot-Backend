package com.groundzero.camw.core.service

import com.google.cloud.firestore.QueryDocumentSnapshot
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.groundzero.camw.core.data.FirestoreMapper
import com.groundzero.camw.utils.getSnapshotValue
import org.springframework.stereotype.Component

@Component
@Suppress("declaration_cant_be_inlined")
class NetworkService(
        private val firestoreService: FirestoreService,
        private val realtimeDatabaseService: RealtimeDatabaseService,
        private val firestoreMapper: FirestoreMapper
) {
    internal inline fun <reified T> readFirestoreDatabase(collectionKey: String): List<T>? = firestoreMapper.getDataAsList(getFirestoreData(collectionKey))

    suspend fun readRealtimeDatabase(collectionKey: String) = realtimeDatabaseService.getData(collectionKey).getSnapshotValue()

    private fun getFirestoreData(collectionKey: String): List<QueryDocumentSnapshot> {
        return firestoreService.getDocuments(collectionKey)
    }
}