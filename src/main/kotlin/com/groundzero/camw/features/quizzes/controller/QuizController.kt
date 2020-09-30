package com.groundzero.camw.features.quizzes.controller

import com.groundzero.camw.core.base.BaseController
import com.groundzero.camw.core.base.BaseRepository
import com.groundzero.camw.features.quizzes.constants.QuizDataType
import com.groundzero.camw.features.quizzes.data.QuizCategory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/quizzes")
class QuizController(repository: BaseRepository<QuizCategory>) : BaseController<QuizCategory>(repository) {

    @GetMapping("/en")
    fun getQuizCategoriesEnglish() = getItemsResponse(QuizDataType.English)

    @GetMapping("/en-staging")
    fun getQuizCategoriesEnglishStaging() = getItemsResponse(QuizDataType.EnglishStaging)

    @GetMapping("/hr")
    fun getQuizCategoriesCroatian() = getItemsResponse(QuizDataType.Croatian)

    @GetMapping("/hr-staging")
    fun getQuizCategoriesCroatianStaging() = getItemsResponse(QuizDataType.CroatianStaging)

    @DeleteMapping("/en")
    fun removeQuizCategoryEnglish(@RequestBody quizCategory: QuizCategory) = removeItemResponse(quizCategory, QuizDataType.English)

    @DeleteMapping("/en-staging")
    fun removeQuizCategoryEnglishStaging(@RequestBody quizCategory: QuizCategory) = removeItemResponse(quizCategory, QuizDataType.EnglishStaging)

    @DeleteMapping("/hr")
    fun removeQuizCategoryCroatian(@RequestBody quizCategory: QuizCategory) = removeItemResponse(quizCategory, QuizDataType.Croatian)

    @DeleteMapping("/hr-staging")
    fun removeQuizCategoryCroatianStaging(@RequestBody quizCategory: QuizCategory) = removeItemResponse(quizCategory, QuizDataType.CroatianStaging)

    @PostMapping("/en")
    fun addQuizCategoryEnglish(@RequestBody quizCategory: QuizCategory) = addItemResponse(quizCategory, QuizDataType.English)

    @PostMapping("/en-staging")
    fun addQuizCategoryEnglishStaging(@RequestBody quizCategory: QuizCategory) = addItemResponse(quizCategory, QuizDataType.EnglishStaging)

    @PostMapping("/hr")
    fun addQuizCategoryCroatian(@RequestBody quizCategory: QuizCategory) = addItemResponse(quizCategory, QuizDataType.Croatian)

    @PostMapping("/hr-staging")
    fun addQuizCategoryCroatianStaging(@RequestBody quizCategory: QuizCategory) = addItemResponse(quizCategory, QuizDataType.CroatianStaging)
}