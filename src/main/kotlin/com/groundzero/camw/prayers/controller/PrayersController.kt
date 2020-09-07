package com.groundzero.camw.prayers.controller

import com.groundzero.camw.network.NetworkResponse
import com.groundzero.camw.prayers.constants.PrayerDataType
import com.groundzero.camw.prayers.data.Prayer
import com.groundzero.camw.prayers.data.PrayersRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/prayers")
class PrayersController(private val repository: PrayersRepository) {

    @GetMapping("/en")
    fun getPrayersEnglish(): NetworkResponse {
        repository.getPrayers(PrayerDataType.English())?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @PostMapping("/en")
    fun addPrayersEnglish(@RequestBody prayer: Prayer): NetworkResponse {
        repository.addPrayer(prayer, PrayerDataType.English())
        return NetworkResponse.Success<Prayer>(200, "Success", mutableListOf())
    }

    @GetMapping("/en-staging")
    fun getPrayersEnglishStaging(): NetworkResponse {
        repository.getPrayers(PrayerDataType.EnglishStaging())?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @PostMapping("/en-staging")
    fun addPrayersEnglishStaging(@RequestBody prayer: Prayer): NetworkResponse {
        repository.addPrayer(prayer, PrayerDataType.EnglishStaging())
        return NetworkResponse.Success<Prayer>(200, "Success", mutableListOf())
    }

    @GetMapping("/hr")
    fun getPrayersCroatian(): NetworkResponse {
        repository.getPrayers(PrayerDataType.Croatian())?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @PostMapping("/hr")
    fun addPrayersCroatian(@RequestBody prayer: Prayer): NetworkResponse {
        repository.addPrayer(prayer, PrayerDataType.Croatian())
        return NetworkResponse.Success<Prayer>(200, "Success", mutableListOf())
    }

    @GetMapping("/hr-staging")
    fun getPrayersCroatianStaging(): NetworkResponse {
        repository.getPrayers(PrayerDataType.CroatianStaging())?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @PostMapping("/hr-staging")
    fun addPrayersCroatianStaging(@RequestBody prayer: Prayer): NetworkResponse {
        repository.addPrayer(prayer, PrayerDataType.CroatianStaging())
        return NetworkResponse.Success<Prayer>(200, "Success", mutableListOf())
    }
}