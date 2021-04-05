package com.groundzero.camw.features.prayers.controller

import com.groundzero.camw.core.base.BaseContentController
import com.groundzero.camw.core.base.BaseContentRepository
import com.groundzero.camw.core.base.BaseContentValidator
import com.groundzero.camw.features.prayers.constants.PrayerDataType
import com.groundzero.camw.features.prayers.data.Prayer
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/prayers")
class PrayersContentController(
        contentRepository: BaseContentRepository<Prayer>,
        contentValidator: BaseContentValidator
) : BaseContentController<Prayer>(contentRepository, contentValidator) {

    @GetMapping("/en")
    fun getPrayerEnglish() = getItemsResponse(PrayerDataType.English)

    @GetMapping("/en-staging")
    fun getPrayerEnglishStaging() = getItemsResponse(PrayerDataType.EnglishStaging)

    @GetMapping("/hr")
    fun getPrayersCroatian() = getItemsResponse(PrayerDataType.Croatian)

    @GetMapping("/hr-staging")
    fun getPrayersCroatianStaging() = getItemsResponse(PrayerDataType.CroatianStaging)

    @GetMapping("/sk")
    fun getPrayersSlovak() = getItemsResponse(PrayerDataType.Slovak)

    @GetMapping("/sk-staging")
    fun getPrayersSlovakStaging() = getItemsResponse(PrayerDataType.SlovakStaging)

    @GetMapping("/es")
    fun getPrayersSpanish() = getItemsResponse(PrayerDataType.Spanish)

    @GetMapping("/es-staging")
    fun getPrayersSpanishStaging() = getItemsResponse(PrayerDataType.SpanishStaging)

    @DeleteMapping("/en")
    fun removePrayerEnglish(@RequestBody prayer: Prayer) = removeItemResponse(prayer, PrayerDataType.English)

    @DeleteMapping("/en-staging")
    fun removePrayerEnglishStaging(@RequestBody prayer: Prayer) = removeItemResponse(prayer, PrayerDataType.EnglishStaging)

    @DeleteMapping("/hr")
    fun removePrayerCroatian(@RequestBody prayer: Prayer) = removeItemResponse(prayer, PrayerDataType.Croatian)

    @DeleteMapping("/hr-staging")
    fun removePrayerCroatianStaging(@RequestBody prayer: Prayer) = removeItemResponse(prayer, PrayerDataType.CroatianStaging)

    @DeleteMapping("/sk")
    fun removePrayerSlovak(@RequestBody prayer: Prayer) = removeItemResponse(prayer, PrayerDataType.Slovak)

    @DeleteMapping("/sk-staging")
    fun removePrayerSlovakStaging(@RequestBody prayer: Prayer) = removeItemResponse(prayer, PrayerDataType.SlovakStaging)

    @DeleteMapping("/es")
    fun removePrayerSpanish(@RequestBody prayer: Prayer) = removeItemResponse(prayer, PrayerDataType.Spanish)

    @DeleteMapping("/es-staging")
    fun removePrayerSpanishStaging(@RequestBody prayer: Prayer) = removeItemResponse(prayer, PrayerDataType.SpanishStaging)

    @PostMapping("/en")
    fun addPrayerEnglish(@RequestBody prayer: Prayer) = addItemResponse(prayer, PrayerDataType.English)

    @PostMapping("/en-staging")
    fun addPrayerEnglishStaging(@RequestBody prayer: Prayer) = addItemResponse(prayer, PrayerDataType.EnglishStaging)

    @PostMapping("/hr")
    fun addPrayerCroatian(@RequestBody prayer: Prayer) = addItemResponse(prayer, PrayerDataType.Croatian)

    @PostMapping("/hr-staging")
    fun addPrayerCroatianStaging(@RequestBody prayer: Prayer) = addItemResponse(prayer, PrayerDataType.CroatianStaging)

    @PostMapping("/sk")
    fun addPrayerSlovak(@RequestBody prayer: Prayer) = addItemResponse(prayer, PrayerDataType.Slovak)

    @PostMapping("/sk-staging")
    fun addPrayerSlovakStaging(@RequestBody prayer: Prayer) = addItemResponse(prayer, PrayerDataType.SlovakStaging)

    @PostMapping("/es")
    fun addPrayerSpanish(@RequestBody prayer: Prayer) = addItemResponse(prayer, PrayerDataType.Spanish)

    @PostMapping("/es-staging")
    fun addPrayerSpanishStaging(@RequestBody prayer: Prayer) = addItemResponse(prayer, PrayerDataType.SpanishStaging)
}