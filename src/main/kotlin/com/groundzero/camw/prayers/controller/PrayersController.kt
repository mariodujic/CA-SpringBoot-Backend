package com.groundzero.camw.prayers.controller

import com.groundzero.camw.data.DataType
import com.groundzero.camw.network.NetworkResponse
import com.groundzero.camw.prayers.constants.PrayerDataType
import com.groundzero.camw.prayers.data.Prayer
import com.groundzero.camw.prayers.data.PrayersRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/prayers")
class PrayersController(private val repository: PrayersRepository) {

    @GetMapping("/en")
    fun getPrayerEnglish() = getPrayersResponse(PrayerDataType.English())

    @GetMapping("/en-staging")
    fun getPrayerEnglishStaging() = getPrayersResponse(PrayerDataType.EnglishStaging())

    @GetMapping("/hr")
    fun getPrayersCroatian() = getPrayersResponse(PrayerDataType.Croatian())

    @GetMapping("/hr-staging")
    fun getPrayersCroatianStaging() = getPrayersResponse(PrayerDataType.CroatianStaging())

    private fun getPrayersResponse(type: DataType): NetworkResponse {
        repository.getPrayers(type)?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @DeleteMapping("/en")
    fun removePrayersEnglish(@RequestBody prayer: Prayer) = removePrayerResponse(prayer, PrayerDataType.English())

    @DeleteMapping("/en-staging")
    fun removePrayersEnglishStaging(@RequestBody prayer: Prayer) = removePrayerResponse(prayer, PrayerDataType.EnglishStaging())

    @DeleteMapping("/hr")
    fun removePrayersCroatian(@RequestBody prayer: Prayer) = removePrayerResponse(prayer, PrayerDataType.Croatian())

    @DeleteMapping("/hr-staging")
    fun removePrayersCroatianStaging(@RequestBody prayer: Prayer) = removePrayerResponse(prayer, PrayerDataType.CroatianStaging())

    private fun removePrayerResponse(@RequestBody prayer: Prayer, type: DataType): NetworkResponse {
        repository.removePrayer(prayer, type)
        return NetworkResponse.Success<Prayer>(200, "Success", mutableListOf())
    }

    @PostMapping("/en")
    fun addPrayersEnglish(@RequestBody prayer: Prayer) = addPrayerResponse(prayer, PrayerDataType.English())

    @PostMapping("/en-staging")
    fun addPrayersEnglishStaging(@RequestBody prayer: Prayer) = addPrayerResponse(prayer, PrayerDataType.EnglishStaging())

    @PostMapping("/hr")
    fun addPrayersCroatian(@RequestBody prayer: Prayer) = addPrayerResponse(prayer, PrayerDataType.Croatian())

    @PostMapping("/hr-staging")
    fun addPrayersCroatianStaging(@RequestBody prayer: Prayer) = addPrayerResponse(prayer, PrayerDataType.CroatianStaging())

    private fun addPrayerResponse(prayer: Prayer, type: DataType): NetworkResponse {
        repository.addPrayer(prayer, type)
        return NetworkResponse.Success<Prayer>(200, "Success", mutableListOf())
    }
}