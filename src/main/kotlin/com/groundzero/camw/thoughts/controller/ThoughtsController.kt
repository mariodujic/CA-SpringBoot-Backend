package com.groundzero.camw.thoughts.controller

import com.groundzero.camw.common.DistributorRepository
import com.groundzero.camw.network.NetworkResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/thoughts")
class ThoughtsController(private val distributorRepository: DistributorRepository) {

    @GetMapping
    fun getThoughts(): NetworkResponse {
        distributorRepository.getThoughts()?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }
}