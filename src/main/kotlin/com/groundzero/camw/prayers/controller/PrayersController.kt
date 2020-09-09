package com.groundzero.camw.prayers.controller

import com.groundzero.camw.core.base.BaseController
import com.groundzero.camw.core.base.BaseRepository
import com.groundzero.camw.prayers.constants.PrayerDataType
import com.groundzero.camw.prayers.data.Prayer
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/prayers")
class PrayersController(private val repository: BaseRepository<Prayer>) : BaseController<Prayer>(repository) {

    @GetMapping("/en")
    fun getPrayerEnglish() = getItemsResponse(PrayerDataType.English())

    @GetMapping("/en-staging")
    fun getPrayerEnglishStaging() = getItemsResponse(PrayerDataType.EnglishStaging())

    @GetMapping("/hr")
    fun getPrayersCroatian() = getItemsResponse(PrayerDataType.Croatian())

    @GetMapping("/hr-staging")
    fun getPrayersCroatianStaging() = getItemsResponse(PrayerDataType.CroatianStaging())

    @DeleteMapping("/en")
    fun removePrayersEnglish(@RequestBody prayer: Prayer) = removeItemResponse(prayer, PrayerDataType.English())

    @DeleteMapping("/en-staging")
    fun removePrayersEnglishStaging(@RequestBody prayer: Prayer) = removeItemResponse(prayer, PrayerDataType.EnglishStaging())

    @DeleteMapping("/hr")
    fun removePrayersCroatian(@RequestBody prayer: Prayer) = removeItemResponse(prayer, PrayerDataType.Croatian())

    @DeleteMapping("/hr-staging")
    fun removePrayersCroatianStaging(@RequestBody prayer: Prayer) = removeItemResponse(prayer, PrayerDataType.CroatianStaging())

    @PostMapping("/en")
    fun addPrayersEnglish(@RequestBody prayer: Prayer) = addItemResponse(prayer, PrayerDataType.English())

    @PostMapping("/en-staging")
    fun addPrayersEnglishStaging(@RequestBody prayer: Prayer) = addItemResponse(prayer, PrayerDataType.EnglishStaging())

    @PostMapping("/hr")
    fun addPrayersCroatian(@RequestBody prayer: Prayer) = addItemResponse(prayer, PrayerDataType.Croatian())

    @PostMapping("/hr-staging")
    fun addPrayersCroatianStaging(@RequestBody prayer: Prayer) = addItemResponse(prayer, PrayerDataType.CroatianStaging())
}