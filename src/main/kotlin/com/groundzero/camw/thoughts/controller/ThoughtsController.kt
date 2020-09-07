package com.groundzero.camw.thoughts.controller

import com.groundzero.camw.network.NetworkResponse
import com.groundzero.camw.thoughts.constants.ThoughtDataType
import com.groundzero.camw.thoughts.data.ThoughtsRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/thoughts")
class ThoughtsController(private val repository: ThoughtsRepository) {

    @GetMapping("/en")
    fun getThoughtsEnglish(): NetworkResponse {
        repository.getThoughts(ThoughtDataType.English())?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @GetMapping("/en-staging")
    fun getThoughtsEnglishStaging(): NetworkResponse {
        repository.getThoughts(ThoughtDataType.EnglishStaging())?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @GetMapping("/hr")
    fun getThoughtsCroatian(): NetworkResponse {
        repository.getThoughts(ThoughtDataType.Croatian())?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    @GetMapping("/hr-staging")
    fun getThoughtsCroatianStaging(): NetworkResponse {
        repository.getThoughts(ThoughtDataType.CroatianStaging())?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }
}