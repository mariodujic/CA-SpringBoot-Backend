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
            .setDatabaseUrl("https://catholic-prayerbook.firebaseio.com")
            .build()

    private fun getFileInput() = FileInputStream("catholic-prayerbook-firebase-adminsdk-vh3gk-41b68d26b9.json")
}