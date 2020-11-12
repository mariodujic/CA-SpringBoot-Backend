package com.groundzero.camw.core.cache.controller

import com.groundzero.camw.core.cache.service.CacheService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CacheController(private val cacheService: CacheService) : CommandLineRunner {

    override fun run(vararg args: String?) {
        cacheService.updateQuizzes()
        cacheService.updatePrayers()
        cacheService.updateThoughts()
        cacheService.updateSaints()
        cacheService.updateInformation()
        cacheService.updateAdConfig()
    }
}