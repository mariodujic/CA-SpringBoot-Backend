package com.groundzero.camw.messaging.service

import com.google.firebase.auth.FirebaseAuthException
import com.groundzero.camw.core.data.providers.FirebaseAuthProvider
import org.springframework.stereotype.Component

@Component
class AuthenticationService(private val firebaseAuth: FirebaseAuthProvider) {

    fun authenticateUser(email: String) = try {
        firebaseAuth.firebaseAuth.getUserByEmail(email)
        true
    } catch (e: FirebaseAuthException) {
        false
    }
}