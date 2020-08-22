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
            .setDatabaseUrl("https://angular-246c3.firebaseio.com")
            .build()

    private fun getFileInput() = FileInputStream("angular-246c3-firebase-adminsdk-lo78s-12e6d7cb1e.json")
}