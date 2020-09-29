package com.groundzero.camw.core.data.providers

import com.google.firebase.auth.FirebaseAuth
import org.springframework.stereotype.Component

@Component
class FirebaseAuthProvider {
    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
}