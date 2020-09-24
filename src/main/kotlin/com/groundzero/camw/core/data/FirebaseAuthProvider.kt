package com.groundzero.camw.core.data

import com.google.firebase.auth.FirebaseAuth
import org.springframework.stereotype.Component

@Component
class FirebaseAuthProvider {
    val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
}