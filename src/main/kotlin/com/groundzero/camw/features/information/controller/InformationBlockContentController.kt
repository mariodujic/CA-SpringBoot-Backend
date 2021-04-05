package com.groundzero.camw.features.information.controller

import com.groundzero.camw.core.base.BaseContentController
import com.groundzero.camw.core.base.BaseContentRepository
import com.groundzero.camw.core.base.BaseContentValidator
import com.groundzero.camw.features.information.constants.InformationBlockDataType
import com.groundzero.camw.features.information.data.InformationBlock
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/information-block")
class InformationBlockContentController(
        contentRepository: BaseContentRepository<InformationBlock>,
        contentValidator: BaseContentValidator
) : BaseContentController<InformationBlock>(contentRepository, contentValidator) {

    @GetMapping("/en")
    fun getInformationBlockEnglish() = getItemsResponse(InformationBlockDataType.English)

    @GetMapping("/en-staging")
    fun getInformationBlockEnglishStaging() = getItemsResponse(InformationBlockDataType.EnglishStaging)

    @GetMapping("/hr")
    fun getInformationBlocksCroatian() = getItemsResponse(InformationBlockDataType.Croatian)

    @GetMapping("/hr-staging")
    fun getInformationBlocksCroatianStaging() = getItemsResponse(InformationBlockDataType.CroatianStaging)

    @GetMapping("/sk")
    fun getInformationBlocksSlovak() = getItemsResponse(InformationBlockDataType.Slovak)

    @GetMapping("/sk-staging")
    fun getInformationBlocksSlovakStaging() = getItemsResponse(InformationBlockDataType.SlovakStaging)

    @GetMapping("/es")
    fun getInformationBlocksSpanish() = getItemsResponse(InformationBlockDataType.Spanish)

    @GetMapping("/es-staging")
    fun getInformationBlocksSpanishStaging() = getItemsResponse(InformationBlockDataType.SpanishStaging)
}