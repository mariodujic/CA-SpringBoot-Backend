package com.groundzero.camw.quizzes.controller

import com.groundzero.camw.network.NetworkResponse
import com.groundzero.camw.quizzes.data.QuizRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/quizzes")
class QuizController(private val repository: QuizRepository) {

    @GetMapping("/en")
    fun getQuizzesEnglish(): NetworkResponse {
        repository.getQuizzesEnglish()?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @GetMapping("/en-staging")
    fun getQuizzesEnglishStaging(): NetworkResponse {
        repository.getQuizzesEnglishStaging()?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @GetMapping("/hr")
    fun getQuizzesCroatian(): NetworkResponse {
        repository.getQuizzesCroatian()?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @GetMapping("/hr-staging")
    fun getQuizzesCroatianStaging(): NetworkResponse {
        repository.getQuizzesCroatianStaging()?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }
}