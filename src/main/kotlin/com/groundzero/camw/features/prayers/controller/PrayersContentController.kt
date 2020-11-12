package com.groundzero.camw.features.prayers.controller

import com.groundzero.camw.core.base.BaseContentController
import com.groundzero.camw.core.base.BaseContentRepository
import com.groundzero.camw.features.prayers.constants.PrayerDataType
import com.groundzero.camw.features.prayers.data.Prayer
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/prayers")
class PrayersContentController(contentRepository: BaseContentRepository<Prayer>) : BaseContentController<Prayer>(contentRepository) {

    @GetMapping("/en")
    fun getPrayerEnglish() = getItemsResponse(PrayerDataType.English)

    @GetMapping("/en-staging")
    fun getPrayerEnglishStaging() = getItemsResponse(PrayerDataType.EnglishStaging)

    @GetMapping("/hr")
    fun getPrayersCroatian() = getItemsResponse(PrayerDataType.Croatian)

    @GetMapping("/hr-staging")
    fun getPrayersCroatianStaging() = getItemsResponse(PrayerDataType.CroatianStaging)

    @DeleteMapping("/en")
    fun removePrayerEnglish(@RequestBody prayer: Prayer) = removeItemResponse(prayer, PrayerDataType.English)

    @DeleteMapping("/en-staging")
    fun removePrayerEnglishStaging(@RequestBody prayer: Prayer) = removeItemResponse(prayer, PrayerDataType.EnglishStaging)

    @DeleteMapping("/hr")
    fun removePrayerCroatian(@RequestBody prayer: Prayer) = removeItemResponse(prayer, PrayerDataType.Croatian)

    @DeleteMapping("/hr-staging")
    fun removePrayerCroatianStaging(@RequestBody prayer: Prayer) = removeItemResponse(prayer, PrayerDataType.CroatianStaging)

    @PostMapping("/en")
    fun addPrayerEnglish(@RequestBody prayer: Prayer) = addItemResponse(prayer, PrayerDataType.English)

    @PostMapping("/en-staging")
    fun addPrayerEnglishStaging(@RequestBody prayer: Prayer) = addItemResponse(prayer, PrayerDataType.EnglishStaging)

    @PostMapping("/hr")
    fun addPrayerCroatian(@RequestBody prayer: Prayer) = addItemResponse(prayer, PrayerDataType.Croatian)

    @PostMapping("/hr-staging")
    fun addPrayerCroatianStaging(@RequestBody prayer: Prayer) = addItemResponse(prayer, PrayerDataType.CroatianStaging)
}