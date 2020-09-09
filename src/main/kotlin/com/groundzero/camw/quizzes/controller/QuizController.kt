package com.groundzero.camw.quizzes.controller

import com.groundzero.camw.data.DataType
import com.groundzero.camw.network.NetworkResponse
import com.groundzero.camw.quizzes.constants.QuizDataType
import com.groundzero.camw.quizzes.data.QuizCategory
import com.groundzero.camw.quizzes.data.QuizRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/quizzes")
class QuizController(private val repository: QuizRepository) {

    @GetMapping("/en")
    fun getQuizzesEnglish() = getQuizzesResponse(QuizDataType.English())

    @GetMapping("/en-staging")
    fun getQuizzesEnglishStaging() = getQuizzesResponse(QuizDataType.EnglishStaging())

    @GetMapping("/hr")
    fun getQuizzesCroatian() = getQuizzesResponse(QuizDataType.Croatian())

    @GetMapping("/hr-staging")
    fun getQuizzesCroatianStaging() = getQuizzesResponse(QuizDataType.CroatianStaging())

    private fun getQuizzesResponse(type: DataType): NetworkResponse {
        repository.getQuizCategories(type)?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @DeleteMapping("/en")
    fun removeQuizCategoryEnglish(@RequestBody quizCategory: QuizCategory) = removeQuizResponse(quizCategory, QuizDataType.English())

    @DeleteMapping("/en-staging")
    fun removeQuizCategoryEnglishStaging(@RequestBody quizCategory: QuizCategory) = removeQuizResponse(quizCategory, QuizDataType.EnglishStaging())

    @DeleteMapping("/hr")
    fun removeQuizCategoryCroatian(@RequestBody quizCategory: QuizCategory) = removeQuizResponse(quizCategory, QuizDataType.Croatian())

    @DeleteMapping("/hr-staging")
    fun removeQuizCategoryCroatianStaging(@RequestBody quizCategory: QuizCategory) = removeQuizResponse(quizCategory, QuizDataType.CroatianStaging())

    private fun removeQuizResponse(@RequestBody quizCategory: QuizCategory, type: DataType): NetworkResponse {
        repository.removeQuizCategory(quizCategory, type)
        return NetworkResponse.Success<QuizCategory>(200, "Success", mutableListOf())
    }

    @PostMapping("/en")
    fun addQuizCategoryEnglish(@RequestBody quizCategory: QuizCategory) = addQuizCategoryResponse(quizCategory, QuizDataType.English())

    @PostMapping("/en-staging")
    fun addQuizCategoryEnglishStaging(@RequestBody quizCategory: QuizCategory) = addQuizCategoryResponse(quizCategory, QuizDataType.EnglishStaging())

    @PostMapping("/hr")
    fun addQuizCategoryCroatian(@RequestBody quizCategory: QuizCategory) = addQuizCategoryResponse(quizCategory, QuizDataType.Croatian())

    @PostMapping("/hr-staging")
    fun addQuizCategoryCroatianStaging(@RequestBody quizCategory: QuizCategory) = addQuizCategoryResponse(quizCategory, QuizDataType.CroatianStaging())

    private fun addQuizCategoryResponse(quizCategory: QuizCategory, type: DataType): NetworkResponse {
        repository.addQuizCategory(quizCategory, type)
        return NetworkResponse.Success<QuizCategory>(200, "Success", mutableListOf())
    }
}