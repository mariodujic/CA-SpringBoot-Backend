package com.groundzero.camw.core.data.providers

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import java.io.FileInputStream

class FirebaseProvider {
    companion object {
        fun initializeFirebase(): FirebaseOptions = FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(getFileInput()))
                .setDatabaseUrl(DATABASE_URL)
                .build().also {
                    FirebaseApp.initializeApp(it)
                }

        private fun getFileInput() = FileInputStream(KEY)
        private const val KEY = "catholic-prayerbook-c8450d33660d.json"
        private const val DATABASE_URL = "https://catholic-prayerbook.firebaseio.com/"
    }
}