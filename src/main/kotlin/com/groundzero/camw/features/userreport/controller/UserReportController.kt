package com.groundzero.camw.features.userreport.controller

import com.groundzero.camw.core.base.BaseContentController
import com.groundzero.camw.core.base.BaseContentRepository
import com.groundzero.camw.core.base.BaseContentValidator
import com.groundzero.camw.features.userreport.constants.UserReportDataType
import com.groundzero.camw.features.userreport.data.UserReport
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user-report")
class UserReportController(
        contentRepository: BaseContentRepository<UserReport>,
        contentValidator: BaseContentValidator
) : BaseContentController<UserReport>(contentRepository, contentValidator) {

    @GetMapping("/en")
    fun getUserReportEnglish() = getItemsResponse(UserReportDataType.English)

    @GetMapping("/en-staging")
    fun getUserReportEnglishStaging() = getItemsResponse(UserReportDataType.EnglishStaging)

    @GetMapping("/hr")
    fun getUserReportCroatian() = getItemsResponse(UserReportDataType.Croatian)

    @GetMapping("/hr-staging")
    fun getUserReportCroatianStaging() = getItemsResponse(UserReportDataType.CroatianStaging)

    @DeleteMapping("/en")
    fun removeUserReportEnglish(@RequestBody report: UserReport) = removeItemResponse(report, UserReportDataType.English)

    @DeleteMapping("/en-staging")
    fun removeUserReportEnglishStaging(@RequestBody report: UserReport) = removeItemResponse(report, UserReportDataType.EnglishStaging)

    @DeleteMapping("/hr")
    fun removeUserReportCroatian(@RequestBody prayer: UserReport) = removeItemResponse(prayer, UserReportDataType.Croatian)

    @DeleteMapping("/hr-staging")
    fun removeUserReportCroatianStaging(@RequestBody prayer: UserReport) = removeItemResponse(prayer, UserReportDataType.CroatianStaging)

    @PostMapping("/en")
    fun addUserReportEnglish(@RequestBody prayer: UserReport) = addItemResponse(prayer, UserReportDataType.English)

    @PostMapping("/en-staging")
    fun addUserReportEnglishStaging(@RequestBody prayer: UserReport) = addItemResponse(prayer, UserReportDataType.EnglishStaging)

    @PostMapping("/hr")
    fun addUserReportCroatian(@RequestBody prayer: UserReport) = addItemResponse(prayer, UserReportDataType.Croatian)

    @PostMapping("/hr-staging")
    fun addUserReportCroatianStaging(@RequestBody prayer: UserReport) = addItemResponse(prayer, UserReportDataType.CroatianStaging)
}