package com.groundzero.camw.core.service

import com.google.firebase.database.DatabaseReference
import com.groundzero.camw.core.data.providers.FirebaseRealtimeDatabaseProvider
import org.springframework.stereotype.Component

@Component
class RealtimeDatabaseService(private val realtimeDatabase: FirebaseRealtimeDatabaseProvider) {
    fun getData(collectionKey: String): DatabaseReference = realtimeDatabase.realtimeDatabase.child(collectionKey)
}