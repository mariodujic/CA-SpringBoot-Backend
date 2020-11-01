package com.groundzero.camw.core.cache.controller

import com.groundzero.camw.core.cache.service.CacheService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CacheController(private val cacheService: CacheService) : CommandLineRunner {

    override fun run(vararg args: String?) {
        CoroutineScope(IO).launch {
            while (true) {
                cacheService.updateQuizzes()
                cacheService.updatePrayers()
                cacheService.updateThoughts()
                cacheService.updateSaints()
                cacheService.updateInformation()
                delay(LOCAL_DATA_UPDATE_DELAY_MIL)
            }
        }
    }

    companion object {
        private const val LOCAL_DATA_UPDATE_DELAY_MIL = 10_800_000L // 180 min
    }
}