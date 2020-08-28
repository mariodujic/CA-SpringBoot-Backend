package com.groundzero.camw.prayers.controller

import com.groundzero.camw.common.DistributorRepository
import com.groundzero.camw.network.NetworkResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/prayers")
class PrayersController(private val distributorRepository: DistributorRepository) {

    @GetMapping
    fun getPrayers(): NetworkResponse {
        distributorRepository.getPrayers()?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }
}