package com.groundzero.camw.core.cache

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
             /*   cache.updateQuizzes()
                cache.updatePrayers()
                cache.updateThoughts()
                cache.updateSaints()*/
                cache.updateInformation()
                delay(LOCAL_DATA_UPDATE_DELAY_MIL)
            }
        }
    }

    companion object {
        private const val LOCAL_DATA_UPDATE_DELAY_MIL = 10_800_000L // 60 min
    }
}