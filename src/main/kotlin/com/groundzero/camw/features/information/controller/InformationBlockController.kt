package com.groundzero.camw.features.information.controller

import com.groundzero.camw.core.base.BaseController
import com.groundzero.camw.core.base.BaseRepository
import com.groundzero.camw.features.information.constants.InformationBlockDataType
import com.groundzero.camw.features.information.data.InformationBlock
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/information-block")
class InformationBlockController(repository: BaseRepository<InformationBlock>) : BaseController<InformationBlock>(repository) {

    @GetMapping("/en")
    fun getInformationBlockEnglish() = getItemsResponse(InformationBlockDataType.English)

    @GetMapping("/en-staging")
    fun getInformationBlockEnglishStaging() = getItemsResponse(InformationBlockDataType.EnglishStaging)

    @GetMapping("/hr")
    fun getInformationBlocksCroatian() = getItemsResponse(InformationBlockDataType.Croatian)

    @GetMapping("/hr-staging")
    fun getInformationBlocksCroatianStaging() = getItemsResponse(InformationBlockDataType.CroatianStaging)
}