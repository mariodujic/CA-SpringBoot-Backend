package com.groundzero.camw.quizzes.controller

import com.groundzero.camw.network.NetworkResponse
import com.groundzero.camw.quizzes.constants.QuizDataType
import com.groundzero.camw.quizzes.data.QuizRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/quizzes")
class QuizController(private val repository: QuizRepository) {

    @GetMapping("/en")
    fun getQuizzesEnglish(): NetworkResponse {
        repository.getQuizCategories(QuizDataType.English())?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @GetMapping("/en-staging")
    fun getQuizzesEnglishStaging(): NetworkResponse {
        repository.getQuizCategories(QuizDataType.EnglishStaging())?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @GetMapping("/hr")
    fun getQuizzesCroatian(): NetworkResponse {
        repository.getQuizCategories(QuizDataType.Croatian())?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @GetMapping("/hr-staging")
    fun getQuizzesCroatianStaging(): NetworkResponse {
        repository.getQuizCategories(QuizDataType.CroatianStaging())?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }
}