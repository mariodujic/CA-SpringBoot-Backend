package com.groundzero.camw.prayers.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.Instant


@RestController
@RequestMapping("/v1.0/prayers")
class PrayersController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getCurrentTime(): String {
        return Instant.now().toString()
    }
}