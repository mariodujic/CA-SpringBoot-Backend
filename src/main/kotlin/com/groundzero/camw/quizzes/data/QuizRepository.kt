package com.groundzero.camw.quizzes.data

import com.groundzero.camw.data.ReadJsonService
import com.groundzero.camw.quizzes.constants.QUIZ_EN_COLLECTION
import com.groundzero.camw.quizzes.constants.QUIZ_EN_COLLECTION_STAGING
import com.groundzero.camw.quizzes.constants.QUIZ_HR_COLLECTION
import com.groundzero.camw.quizzes.constants.QUIZ_HR_COLLECTION_STAGING
import com.groundzero.camw.utils.getJsonStoragePath
import org.springframework.stereotype.Component

@Component
class QuizRepository(private val readJsonService: ReadJsonService) {

    fun getQuizzesEnglish() = readJsonService.readJson<QuizCategory>(getJsonStoragePath(QUIZ_EN_COLLECTION))
    fun getQuizzesEnglishStaging() = readJsonService.readJson<QuizCategory>(getJsonStoragePath(QUIZ_EN_COLLECTION_STAGING))
    fun getQuizzesCroatian() = readJsonService.readJson<QuizCategory>(getJsonStoragePath(QUIZ_HR_COLLECTION))
    fun getQuizzesCroatianStaging() = readJsonService.readJson<QuizCategory>(getJsonStoragePath(QUIZ_HR_COLLECTION_STAGING))
}