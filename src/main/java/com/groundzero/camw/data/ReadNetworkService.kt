package com.groundzero.camw.data

import com.google.cloud.firestore.QueryDocumentSnapshot
import com.groundzero.camw.prayers.constants.PRAYERS_ENGLISH_COLLECTION
import com.groundzero.camw.prayers.data.Prayer
import com.groundzero.camw.quizzes.constants.QUIZZES_ENGLISH_COLLECTION
import com.groundzero.camw.quizzes.data.QuizCategory
import com.groundzero.camw.thoughts.constants.THOUGHTS_ENGLISH_COLLECTION
import com.groundzero.camw.thoughts.data.Thought
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ReadNetworkService {

    @Autowired
    private lateinit var firebaseDatabase: FirebaseDatabase

    internal inline fun <reified T> readDatabase(): List<T>? {

        when (T::class) {
            Prayer::class -> return getDataAsList(PRAYERS_ENGLISH_COLLECTION)
            Thought::class -> return getDataAsList(THOUGHTS_ENGLISH_COLLECTION)
            QuizCategory::class -> return getDataAsList(QUIZZES_ENGLISH_COLLECTION)
        }
        return null
    }

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