package com.groundzero.camw.common

import com.groundzero.camw.data.ReadJsonService
import com.groundzero.camw.prayers.constants.PRAYER_EN_COLLECTION
import com.groundzero.camw.prayers.constants.PRAYER_HR_COLLECTION
import com.groundzero.camw.prayers.data.Prayer
import com.groundzero.camw.quizzes.constants.QUIZ_EN_COLLECTION
import com.groundzero.camw.quizzes.constants.QUIZ_HR_COLLECTION
import com.groundzero.camw.quizzes.data.QuizCategory
import com.groundzero.camw.thoughts.constants.THOUGHT_EN_COLLECTION
import com.groundzero.camw.thoughts.constants.THOUGHT_HR_COLLECTION
import com.groundzero.camw.thoughts.data.Thought
import com.groundzero.camw.utils.getJsonStoragePath
import org.springframework.stereotype.Component

@Component
class DistributorRepository(private val readJsonService: ReadJsonService) {

    fun getPrayersEnglish() = readJsonService.readJson<Prayer>(getJsonStoragePath(PRAYER_EN_COLLECTION))
    fun getThoughtsEnglish() = readJsonService.readJson<Thought>(getJsonStoragePath(THOUGHT_EN_COLLECTION))
    fun getQuizzesEnglish() = readJsonService.readJson<QuizCategory>(getJsonStoragePath(QUIZ_EN_COLLECTION))

    fun getPrayersCroatian() = readJsonService.readJson<Prayer>(getJsonStoragePath(PRAYER_HR_COLLECTION))
    fun getThoughtsCroatian() = readJsonService.readJson<Thought>(getJsonStoragePath(THOUGHT_HR_COLLECTION))
    fun getQuizzesCroatian() = readJsonService.readJson<QuizCategory>(getJsonStoragePath(QUIZ_HR_COLLECTION))
}