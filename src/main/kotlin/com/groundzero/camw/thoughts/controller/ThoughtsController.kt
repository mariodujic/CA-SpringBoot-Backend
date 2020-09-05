package com.groundzero.camw.thoughts.controller

import com.groundzero.camw.network.NetworkResponse
import com.groundzero.camw.thoughts.data.ThoughtsRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/thoughts")
class ThoughtsController(private val repository: ThoughtsRepository) {

    @GetMapping("/en")
    fun getThoughtsEnglish(): NetworkResponse {
        repository.getThoughtsEnglish()?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @GetMapping("/en-staging")
    fun getThoughtsEnglishStaging(): NetworkResponse {
        repository.getThoughtsEnglishStaging()?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @GetMapping("/hr")
    fun getThoughtsCroatian(): NetworkResponse {
        repository.getThoughtsCroatian()?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @GetMapping("/hr-staging")
    fun getThoughtsCroatianStaging(): NetworkResponse {
        repository.getThoughtsCroatianStaging()?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }
}