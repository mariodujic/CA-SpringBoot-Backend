package com.groundzero.camw.prayers.controller

import com.groundzero.camw.network.NetworkResponse
import com.groundzero.camw.prayers.data.PrayersRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/prayers")
class PrayersController(private val repository: PrayersRepository) {

    @GetMapping("/en")
    fun getPrayersEnglish(): NetworkResponse {
        repository.getPrayersEnglish()?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @GetMapping("/hr")
    fun getPrayersCroatian(): NetworkResponse {
        repository.getPrayersCroatian()?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }
}