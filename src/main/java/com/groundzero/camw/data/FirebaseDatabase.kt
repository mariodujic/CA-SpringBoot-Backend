package com.groundzero.camw.data

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Component
import java.io.FileInputStream

@Component
class FirebaseDatabase {

    fun getFirestore(): Firestore {
        FirebaseApp.initializeApp(getFirebaseOptions())
        return FirestoreClient.getFirestore()
    }

    private fun getFirebaseOptions() = FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(getFileInput()))
            .setDatabaseUrl(DATABASE_URL)
            .build()

    private fun getFileInput() = FileInputStream(KEY)

    companion object {
        private const val DATABASE_URL = "https://catholic-prayerbook.firebaseio.com"
        private const val KEY = "catholic-prayerbook-firebase-adminsdk-vh3gk-41b68d26b9.json"
    }
}