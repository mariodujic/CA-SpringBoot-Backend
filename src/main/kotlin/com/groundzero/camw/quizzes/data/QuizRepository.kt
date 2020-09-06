package com.groundzero.camw.quizzes.data

import com.groundzero.camw.data.ReadJsonService
import com.groundzero.camw.quizzes.constants.QUIZ_EN_COLLECTION
import com.groundzero.camw.quizzes.constants.QUIZ_EN_COLLECTION_STAGING
import com.groundzero.camw.quizzes.constants.QUIZ_HR_COLLECTION
import com.groundzero.camw.quizzes.constants.QUIZ_HR_COLLECTION_STAGING
import org.springframework.stereotype.Component

@Component
class QuizRepository(private val readJson: ReadJsonService) {

    fun getQuizzesEnglish() = readJson.read<QuizCategory>(QUIZ_EN_COLLECTION)
    fun getQuizzesEnglishStaging() = readJson.read<QuizCategory>(QUIZ_EN_COLLECTION_STAGING)
    fun getQuizzesCroatian() = readJson.read<QuizCategory>(QUIZ_HR_COLLECTION)
    fun getQuizzesCroatianStaging() = readJson.read<QuizCategory>(QUIZ_HR_COLLECTION_STAGING)
}