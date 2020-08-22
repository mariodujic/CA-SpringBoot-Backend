package com.groundzero.camw.controller

import com.groundzero.camw.data.FirebaseDatabase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.Instant


@RestController
@RequestMapping("/v1.0/prayers")
class PrayersController {

    @Autowired
    private lateinit var firebaseDatabase: FirebaseDatabase

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getCurrentTime(): String {

        println(firebaseDatabase.getFirestore())

        return Instant.now().toString()
    }
}