package com.groundzero.camw.features.adconfig.controller

import com.groundzero.camw.core.base.BaseConfigController
import com.groundzero.camw.core.base.BaseConfigRepository
import com.groundzero.camw.features.adconfig.constants.AdConfigDataType
import com.groundzero.camw.features.adconfig.data.AdConfig
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/ad-config")
class AdConfigController(repository: BaseConfigRepository<AdConfig>) : BaseConfigController<AdConfig>(repository) {

    @GetMapping("/en")
    fun getAdConfigEnglish() = getItemsResponse(AdConfigDataType.English)

    @GetMapping("/en-staging")
    fun getAdConfigEnglishStaging() = getItemsResponse(AdConfigDataType.EnglishStaging)

    @GetMapping("/hr")
    fun getAdConfigsCroatian() = getItemsResponse(AdConfigDataType.Croatian)

    @GetMapping("/hr-staging")
    fun getAdConfigsCroatianStaging() = getItemsResponse(AdConfigDataType.CroatianStaging)

    @GetMapping("/sk")
    fun getAdConfigsSlovak() = getItemsResponse(AdConfigDataType.Slovak)

    @GetMapping("/sk-staging")
    fun getAdConfigsSlovakStaging() = getItemsResponse(AdConfigDataType.SlovakStaging)

    @PostMapping("/en")
    fun addAdConfigEnglish(@RequestBody adConfig: AdConfig) = addItemResponse(adConfig, AdConfigDataType.English)

    @PostMapping("/en-staging")
    fun addAdConfigEnglishStaging(@RequestBody adConfig: AdConfig) = addItemResponse(adConfig, AdConfigDataType.EnglishStaging)

    @PostMapping("/hr")
    fun addAdConfigsCroatian(@RequestBody adConfig: AdConfig) = addItemResponse(adConfig, AdConfigDataType.Croatian)

    @PostMapping("/hr-staging")
    fun addAdConfigsCroatianStaging(@RequestBody adConfig: AdConfig) = addItemResponse(adConfig, AdConfigDataType.CroatianStaging)

    @PostMapping("/sk")
    fun addAdConfigsSlovak(@RequestBody adConfig: AdConfig) = addItemResponse(adConfig, AdConfigDataType.Slovak)

    @PostMapping("/sk-staging")
    fun addAdConfigsSlovakStaging(@RequestBody adConfig: AdConfig) = addItemResponse(adConfig, AdConfigDataType.SlovakStaging)
}