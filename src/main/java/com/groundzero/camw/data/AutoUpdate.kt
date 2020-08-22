package com.groundzero.camw.data

import com.groundzero.camw.prayers.data.Prayer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class AutoUpdate {

    @Autowired
    private lateinit var firebaseDatabase: FirebaseDatabase

    fun getData() {
        val apiFuture = firebaseDatabase.getFirestore().collection("en-prayers").get()
        val querySnapshot = apiFuture.get()
        val documents = querySnapshot.documents
        for (i in documents) {
            val data = i.toObject(Prayer::class.java)
            println(data)
        }
    }
}