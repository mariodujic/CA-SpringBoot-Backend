package com.groundzero.camw.prayers.controller

import com.groundzero.camw.network.NetworkResponse
import com.groundzero.camw.prayers.data.Prayer
import com.groundzero.camw.prayers.data.PrayersRepository
import org.springframework.web.bind.annotation.*

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

    @GetMapping("/en-staging")
    fun getPrayersEnglishStaging(): NetworkResponse {
        repository.getPrayersEnglishStaging()?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @PostMapping("/en-staging")
    fun addPrayersEnglishStaging(@RequestBody prayer: Prayer): NetworkResponse {
        repository.addPrayerEnglishStaging(prayer)
        return NetworkResponse.Success<Prayer>(200, "Success", mutableListOf())
    }

    @GetMapping("/hr")
    fun getPrayersCroatian(): NetworkResponse {
        repository.getPrayersCroatian()?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @GetMapping("/hr-staging")
    fun getPrayersCroatianStaging(): NetworkResponse {
        repository.getPrayersCroatianStaging()?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }
}