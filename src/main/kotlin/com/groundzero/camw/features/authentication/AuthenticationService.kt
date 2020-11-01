package com.groundzero.camw.features.authentication

import com.groundzero.camw.core.data.providers.FirebaseAuthProvider
import org.springframework.stereotype.Component

@Component
class AuthenticationService(private val firebaseAuth: FirebaseAuthProvider) {

    fun authenticateUser(authenticationRequest: AuthenticationRequest): Boolean {
        return getUserEmailByUid(authenticationRequest.uid) == authenticationRequest.email
    }

    private fun getUserEmailByUid(uid: String) = firebaseAuth.firebaseAuth.getUser(uid).email
}