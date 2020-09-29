package com.groundzero.camw.core.data.providers

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.springframework.stereotype.Component

@Component
class FirebaseRealtimeDatabaseProvider {
    val realtimeDatabase: DatabaseReference = FirebaseDatabase.getInstance().reference
}