package com.groundzero.camw.cachier

import com.groundzero.camw.data.ReadNetworkService
import com.groundzero.camw.data.WriteJsonService
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
class CacheRepository(
        private val readNetworkService: ReadNetworkService,
        private val writeJsonService: WriteJsonService
) {

    fun readNetworkQuizzesEnglish(): List<QuizCategory>? = readNetworkService.readDatabase(QUIZ_EN_COLLECTION)
    fun readNetworkPrayersEnglish(): List<Prayer>? = readNetworkService.readDatabase(PRAYER_EN_COLLECTION)
    fun readNetworkThoughtsEnglish(): List<Thought>? = readNetworkService.readDatabase(THOUGHT_EN_COLLECTION)

    fun writeJsonQuizzesEnglish(quizzes: List<QuizCategory>): Boolean = writeJsonService.writeJson(getJsonStoragePath(QUIZ_EN_COLLECTION), quizzes)
    fun writeJsonPrayersEnglish(prayers: List<Prayer>): Boolean = writeJsonService.writeJson(getJsonStoragePath(PRAYER_EN_COLLECTION), prayers)
    fun writeJsonThoughtsEnglish(thoughts: List<Thought>): Boolean = writeJsonService.writeJson(getJsonStoragePath(THOUGHT_EN_COLLECTION), thoughts)

    fun readNetworkQuizzesCroatian(): List<QuizCategory>? = readNetworkService.readDatabase(QUIZ_HR_COLLECTION)
    fun readNetworkPrayersCroatian(): List<Prayer>? = readNetworkService.readDatabase(PRAYER_HR_COLLECTION)
    fun readNetworkThoughtsCroatian(): List<Thought>? = readNetworkService.readDatabase(THOUGHT_HR_COLLECTION)

    fun writeJsonQuizzesCroatian(quizzes: List<QuizCategory>): Boolean = writeJsonService.writeJson(getJsonStoragePath(QUIZ_HR_COLLECTION), quizzes)
    fun writeJsonPrayersCroatian(prayers: List<Prayer>): Boolean = writeJsonService.writeJson(getJsonStoragePath(PRAYER_HR_COLLECTION), prayers)
    fun writeJsonThoughtsCroatian(thoughts: List<Thought>): Boolean = writeJsonService.writeJson(getJsonStoragePath(THOUGHT_HR_COLLECTION), thoughts)
}