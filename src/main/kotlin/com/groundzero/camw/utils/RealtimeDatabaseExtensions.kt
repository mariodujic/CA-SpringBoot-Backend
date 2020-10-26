package com.groundzero.camw.utils

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun DatabaseReference.getSnapshotValue(): DataSnapshot {
    return withContext(Dispatchers.IO) {
        suspendCoroutine<DataSnapshot> { continuation ->
            addListenerForSingleValueEvent(RealtimeDatabaseValueEventListener(
                    onDataChange = { continuation.resume(it) },
                    onError = { continuation.resumeWithException(it.toException()) }
            ))
        }
    }
}

private class RealtimeDatabaseValueEventListener(val onDataChange: (DataSnapshot) -> Unit, val onError: (DatabaseError) -> Unit) : ValueEventListener {
    override fun onDataChange(data: DataSnapshot) = onDataChange.invoke(data)
    override fun onCancelled(error: DatabaseError) = onError.invoke(error)
}