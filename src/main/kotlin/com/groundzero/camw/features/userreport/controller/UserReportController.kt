package com.groundzero.camw.features.userreport.controller

import com.groundzero.camw.core.base.BaseContentControllerWithFirestore
import com.groundzero.camw.core.base.BaseContentRepository
import com.groundzero.camw.core.base.BaseContentValidator
import com.groundzero.camw.core.repository.FirestoreRepository
import com.groundzero.camw.features.userreport.constants.UserReportDataType
import com.groundzero.camw.features.userreport.data.UserReport
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user-report")
class UserReportController(
        contentRepository: BaseContentRepository<UserReport>,
        contentValidator: BaseContentValidator,
        firestoreRepository: FirestoreRepository
) : BaseContentControllerWithFirestore<UserReport>(contentRepository, contentValidator, firestoreRepository) {

    @GetMapping("/en")
    fun getUserReportEnglish() = getItemsResponse(UserReportDataType.English)

    @GetMapping("/en-staging")
    fun getUserReportEnglishStaging() = getItemsResponse(UserReportDataType.EnglishStaging)

    @GetMapping("/hr")
    fun getUserReportCroatian() = getItemsResponse(UserReportDataType.Croatian)

    @GetMapping("/hr-staging")
    fun getUserReportCroatianStaging() = getItemsResponse(UserReportDataType.CroatianStaging)

    @GetMapping("/sk")
    fun getUserReportSlovak() = getItemsResponse(UserReportDataType.Slovak)

    @GetMapping("/sk-staging")
    fun getUserReportSlovakStaging() = getItemsResponse(UserReportDataType.SlovakStaging)

    @GetMapping("/es")
    fun getUserReportSpanish() = getItemsResponse(UserReportDataType.Spanish)

    @GetMapping("/es-staging")
    fun getUserReportSpanishStaging() = getItemsResponse(UserReportDataType.SpanishStaging)

    @DeleteMapping("/en")
    fun removeUserReportEnglish(@RequestBody report: UserReport) = removeItemResponse(report, UserReportDataType.English)

    @DeleteMapping("/en-staging")
    fun removeUserReportEnglishStaging(@RequestBody report: UserReport) = removeItemResponse(report, UserReportDataType.EnglishStaging)

    @DeleteMapping("/hr")
    fun removeUserReportCroatian(@RequestBody userReport: UserReport) = removeItemResponse(userReport, UserReportDataType.Croatian)

    @DeleteMapping("/hr-staging")
    fun removeUserReportCroatianStaging(@RequestBody userReport: UserReport) = removeItemResponse(userReport, UserReportDataType.CroatianStaging)

    @DeleteMapping("/sk")
    fun removeUserReportSlovak(@RequestBody userReport: UserReport) = removeItemResponse(userReport, UserReportDataType.Slovak)

    @DeleteMapping("/sk-staging")
    fun removeUserReportSlovakStaging(@RequestBody userReport: UserReport) = removeItemResponse(userReport, UserReportDataType.SlovakStaging)

    @DeleteMapping("/es")
    fun removeUserReportSpanish(@RequestBody userReport: UserReport) = removeItemResponse(userReport, UserReportDataType.Spanish)

    @DeleteMapping("/es-staging")
    fun removeUserReportSpanishStaging(@RequestBody userReport: UserReport) = removeItemResponse(userReport, UserReportDataType.SpanishStaging)

    @PostMapping("/en")
    fun addUserReportEnglish(@RequestBody userReport: UserReport) = addItemResponse(userReport, UserReportDataType.English)

    @PostMapping("/en-staging")
    fun addUserReportEnglishStaging(@RequestBody userReport: UserReport) = addItemResponse(userReport, UserReportDataType.EnglishStaging)

    @PostMapping("/hr")
    fun addUserReportCroatian(@RequestBody userReport: UserReport) = addItemResponse(userReport, UserReportDataType.Croatian)

    @PostMapping("/hr-staging")
    fun addUserReportCroatianStaging(@RequestBody userReport: UserReport) = addItemResponse(userReport, UserReportDataType.CroatianStaging)

    @PostMapping("/sk")
    fun addUserReportSlovak(@RequestBody userReport: UserReport) = addItemResponse(userReport, UserReportDataType.Slovak)

    @PostMapping("/sk-staging")
    fun addUserReportSlovakStaging(@RequestBody userReport: UserReport) = addItemResponse(userReport, UserReportDataType.SlovakStaging)

    @PostMapping("/es")
    fun addUserReportSpanish(@RequestBody userReport: UserReport) = addItemResponse(userReport, UserReportDataType.Spanish)

    @PostMapping("/es-staging")
    fun addUserReportSpanishStaging(@RequestBody userReport: UserReport) = addItemResponse(userReport, UserReportDataType.SpanishStaging)
}