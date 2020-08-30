package com.groundzero.camw.data

import com.google.cloud.firestore.QueryDocumentSnapshot
import org.springframework.stereotype.Component

/**
 * 'inline' modifier is not allowed on virtual members
 */
@Component
class FirestoreMapper : FirestoreMapperImpl()

open class FirestoreMapperImpl {

    inline fun <reified T> getDataAsList(collection: List<QueryDocumentSnapshot>): List<T> {
        val prayerList = mutableListOf<T>()

        for (i in collection) {
            val data = i.toObject(T::class.java)
            prayerList.add(data)
        }
        return prayerList
    }
}