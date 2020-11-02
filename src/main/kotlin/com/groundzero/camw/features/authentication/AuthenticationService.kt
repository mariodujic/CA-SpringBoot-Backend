package com.groundzero.camw.features.authentication

import com.groundzero.camw.core.data.providers.FirebaseAuthProvider
import org.springframework.stereotype.Component

@Component
class AuthenticationService(private val firebaseAuth: FirebaseAuthProvider) {

    fun authenticateUser(uid: String?): Boolean {
        return uid?.let {
            !getUserEmailByUid(it).isNullOrBlank()
        } ?: false
    }

    private fun getUserEmailByUid(uid: String) = firebaseAuth.firebaseAuth.getUser(uid).email
}