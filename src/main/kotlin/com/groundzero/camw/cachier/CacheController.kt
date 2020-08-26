package com.groundzero.camw.cachier

import com.groundzero.camw.prayers.constants.PRAYER_EN_COLLECTION
import com.groundzero.camw.quizzes.constants.QUIZ_EN_COLLECTION
import com.groundzero.camw.thoughts.constants.THOUGHT_EN_COLLECTION
import com.groundzero.camw.utils.getJsonLog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CacheController(private val repository: CacheRepository) : CommandLineRunner {

    override fun run(vararg args: String?) {
        CoroutineScope(IO).launch {
            while (true) {
                delay(LOCAL_DATA_UPDATE_DELAY_MIL)
                updatePrayers()
                updateThoughts()
                updateQuizzes()
            }
        }
    }

    private fun updateQuizzes() = repository.readNetworkQuizzes()?.let { repository.writeJsonQuizzes(it).getJsonLog(QUIZ_EN_COLLECTION) }
    private fun updatePrayers() = repository.readNetworkPrayers()?.let { repository.writeJsonPrayers(it).getJsonLog(PRAYER_EN_COLLECTION) }
    private fun updateThoughts() = repository.readNetworkThoughts()?.let { repository.writeJsonThoughts(it).getJsonLog(THOUGHT_EN_COLLECTION) }

    companion object {
        private const val LOCAL_DATA_UPDATE_DELAY_MIL = 3_600_000L // 60 min
    }
}