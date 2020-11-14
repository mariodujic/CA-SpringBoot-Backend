package com.groundzero.camw.features.saints.controller

import com.groundzero.camw.core.base.BaseContentController
import com.groundzero.camw.core.base.BaseContentRepository
import com.groundzero.camw.core.base.BaseContentValidator
import com.groundzero.camw.features.saints.constants.SaintsDataType
import com.groundzero.camw.features.saints.data.Saint
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/saints")
class SaintsContentController(
        contentRepository: BaseContentRepository<Saint>,
        contentValidator: BaseContentValidator
) : BaseContentController<Saint>(contentRepository, contentValidator) {

    @GetMapping("/en")
    fun getSaintssEnglish() = getItemsResponse(SaintsDataType.English)

    @GetMapping("/en-staging")
    fun getSaintssEnglishStaging() = getItemsResponse(SaintsDataType.EnglishStaging)

    @GetMapping("/hr")
    fun getSaintssCroatian() = getItemsResponse(SaintsDataType.Croatian)

    @GetMapping("/hr-staging")
    fun getSaintssCroatianStaging() = getItemsResponse(SaintsDataType.CroatianStaging)

    @DeleteMapping("/en")
    fun removeSaintsEnglish(@RequestBody saint: Saint) = removeItemResponse(saint, SaintsDataType.English)

    @DeleteMapping("/en-staging")
    fun removeSaintsEnglishStaging(@RequestBody saint: Saint) = removeItemResponse(saint, SaintsDataType.EnglishStaging)

    @DeleteMapping("/hr")
    fun removeSaintsCroatian(@RequestBody saint: Saint) = removeItemResponse(saint, SaintsDataType.Croatian)

    @DeleteMapping("/hr-staging")
    fun removeSaintsCroatianStaging(@RequestBody saint: Saint) = removeItemResponse(saint, SaintsDataType.CroatianStaging)

    @PostMapping("/en")
    fun addSaintsEnglish(@RequestBody saint: Saint) = addItemResponse(saint, SaintsDataType.English)

    @PostMapping("/en-staging")
    fun addSaintsEnglishStaging(@RequestBody saint: Saint) = addItemResponse(saint, SaintsDataType.EnglishStaging)

    @PostMapping("/hr")
    fun addSaintsCroatian(@RequestBody saint: Saint) = addItemResponse(saint, SaintsDataType.Croatian)

    @PostMapping("/hr-staging")
    fun addSaintsCroatianStaging(@RequestBody saint: Saint) = addItemResponse(saint, SaintsDataType.CroatianStaging)
}