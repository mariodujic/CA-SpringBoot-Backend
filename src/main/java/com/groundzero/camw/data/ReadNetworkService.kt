package com.groundzero.camw.data

import com.google.cloud.firestore.QueryDocumentSnapshot
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ReadNetworkService {

    @Autowired
    private lateinit var firebaseDatabase: FirebaseDatabase

    internal inline fun <reified T> readDatabase(collectionKey: String): List<T> = getDataAsList(collectionKey)

    private inline fun <reified T> getDataAsList(collectionKey: String): List<T> {
        val prayerList = mutableListOf<T>()

        for (i in getCollection(collectionKey)) {
            val data = i.toObject(T::class.java)
            prayerList.add(data)
        }
        return prayerList
    }

    private fun getCollection(collectionKey: String): List<QueryDocumentSnapshot> {
        val apiFuture = firebaseDatabase.firestore.collection(collectionKey).get()
        val querySnapshot = apiFuture.get()
        return querySnapshot.documents
    }
}