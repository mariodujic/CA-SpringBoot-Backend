package com.groundzero.camw.cachier

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CacheController(private val cache: Cache) : CommandLineRunner {

    override fun run(vararg args: String?) {
        CoroutineScope(IO).launch {
            while (true) {
                cache.updateQuizzes()
                cache.updatePrayers()
                cache.updateThoughts()
                delay(LOCAL_DATA_UPDATE_DELAY_MIL)
            }
        }
    }

    companion object {
        private const val LOCAL_DATA_UPDATE_DELAY_MIL = 3_600_000L // 60 min
    }
}