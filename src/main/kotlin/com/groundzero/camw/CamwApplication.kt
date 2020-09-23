package com.groundzero.camw

import com.groundzero.camw.core.data.FirebaseProvider
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class CamwApplication

fun main(args: Array<String>) {
    FirebaseProvider.initializeFirebase()
    runApplication<CamwApplication>(*args)
}