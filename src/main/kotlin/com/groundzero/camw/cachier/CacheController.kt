package com.groundzero.camw.cachier

import com.groundzero.camw.prayers.constants.PRAYER_EN_COLLECTION
import com.groundzero.camw.prayers.constants.PRAYER_HR_COLLECTION
import com.groundzero.camw.quizzes.constants.QUIZ_EN_COLLECTION
import com.groundzero.camw.quizzes.constants.QUIZ_HR_COLLECTION
import com.groundzero.camw.thoughts.constants.THOUGHT_EN_COLLECTION
import com.groundzero.camw.thoughts.constants.THOUGHT_HR_COLLECTION
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
                updatePrayers()
                updateThoughts()
                updateQuizzes()
                delay(LOCAL_DATA_UPDATE_DELAY_MIL)
            }
        }
    }

    private fun updateQuizzes() {
        repository.readNetworkQuizzesEnglish()?.let { repository.writeJsonQuizzesEnglish(it).getJsonLog(QUIZ_EN_COLLECTION) }
        repository.readNetworkQuizzesCroatian()?.let { repository.writeJsonQuizzesCroatian(it).getJsonLog(QUIZ_HR_COLLECTION) }
    }

    private fun updatePrayers() {
        repository.readNetworkPrayersEnglish()?.let { repository.writeJsonPrayersEnglish(it).getJsonLog(PRAYER_EN_COLLECTION) }
        repository.readNetworkPrayersCroatian()?.let { repository.writeJsonPrayersCroatian(it).getJsonLog(PRAYER_HR_COLLECTION) }
    }

    private fun updateThoughts() {
        repository.readNetworkThoughtsEnglish()?.let { repository.writeJsonThoughtsEnglish(it).getJsonLog(THOUGHT_EN_COLLECTION) }
        repository.readNetworkThoughtsCroatian()?.let { repository.writeJsonThoughtsCroatian(it).getJsonLog(THOUGHT_HR_COLLECTION) }
    }

    companion object {
        private const val LOCAL_DATA_UPDATE_DELAY_MIL = 3_600_000L // 60 min
    }
}