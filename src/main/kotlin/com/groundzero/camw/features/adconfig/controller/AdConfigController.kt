package com.groundzero.camw.features.adconfig.controller

import com.groundzero.camw.core.base.BaseConfigController
import com.groundzero.camw.core.base.BaseConfigRepository
import com.groundzero.camw.features.adconfig.constants.AdConfigDataType
import com.groundzero.camw.features.adconfig.data.AdConfig
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}