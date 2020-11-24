package com.groundzero.camw.features.quizzes.controller

import com.groundzero.camw.core.base.BaseContentController
import com.groundzero.camw.core.base.BaseContentRepository
import com.groundzero.camw.core.base.BaseContentValidator
import com.groundzero.camw.features.quizzes.constants.QuizDataType
import com.groundzero.camw.features.quizzes.data.QuizCategory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/quizzes")
class QuizContentController(
        contentRepository: BaseContentRepository<QuizCategory>,
        contentValidator: BaseContentValidator
) : BaseContentController<QuizCategory>(contentRepository, contentValidator) {

    @GetMapping("/en")
    fun getQuizCategoriesEnglish() = getItemsResponse(QuizDataType.English)

    @GetMapping("/en-staging")
    fun getQuizCategoriesEnglishStaging() = getItemsResponse(QuizDataType.EnglishStaging)

    @GetMapping("/hr")
    fun getQuizCategoriesCroatian() = getItemsResponse(QuizDataType.Croatian)

    @GetMapping("/hr-staging")
    fun getQuizCategoriesCroatianStaging() = getItemsResponse(QuizDataType.CroatianStaging)

    @GetMapping("/sk")
    fun getQuizCategoriesSlovak() = getItemsResponse(QuizDataType.Slovak)

    @GetMapping("/sk-staging")
    fun getQuizCategoriesSlovakStaging() = getItemsResponse(QuizDataType.SlovakStaging)

    @DeleteMapping("/en")
    fun removeQuizCategoryEnglish(@RequestBody quizCategory: QuizCategory) = removeItemResponse(quizCategory, QuizDataType.English)

    @DeleteMapping("/en-staging")
    fun removeQuizCategoryEnglishStaging(@RequestBody quizCategory: QuizCategory) = removeItemResponse(quizCategory, QuizDataType.EnglishStaging)

    @DeleteMapping("/hr")
    fun removeQuizCategoryCroatian(@RequestBody quizCategory: QuizCategory) = removeItemResponse(quizCategory, QuizDataType.Croatian)

    @DeleteMapping("/hr-staging")
    fun removeQuizCategoryCroatianStaging(@RequestBody quizCategory: QuizCategory) = removeItemResponse(quizCategory, QuizDataType.CroatianStaging)

    @DeleteMapping("/sk")
    fun removeQuizCategorySlovak(@RequestBody quizCategory: QuizCategory) = removeItemResponse(quizCategory, QuizDataType.Slovak)

    @DeleteMapping("/sk-staging")
    fun removeQuizCategorySlovakStaging(@RequestBody quizCategory: QuizCategory) = removeItemResponse(quizCategory, QuizDataType.SlovakStaging)

    @PostMapping("/en")
    fun addQuizCategoryEnglish(@RequestBody quizCategory: QuizCategory) = addItemResponse(quizCategory, QuizDataType.English)

    @PostMapping("/en-staging")
    fun addQuizCategoryEnglishStaging(@RequestBody quizCategory: QuizCategory) = addItemResponse(quizCategory, QuizDataType.EnglishStaging)

    @PostMapping("/hr")
    fun addQuizCategoryCroatian(@RequestBody quizCategory: QuizCategory) = addItemResponse(quizCategory, QuizDataType.Croatian)

    @PostMapping("/hr-staging")
    fun addQuizCategoryCroatianStaging(@RequestBody quizCategory: QuizCategory) = addItemResponse(quizCategory, QuizDataType.CroatianStaging)

    @PostMapping("/sk")
    fun addQuizCategorySlovak(@RequestBody quizCategory: QuizCategory) = addItemResponse(quizCategory, QuizDataType.Slovak)

    @PostMapping("/sk-staging")
    fun addQuizCategorySlovakStaging(@RequestBody quizCategory: QuizCategory) = addItemResponse(quizCategory, QuizDataType.SlovakStaging)
}