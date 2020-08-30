package com.groundzero.camw.quizzes.data

import com.groundzero.camw.data.ReadJson
import com.groundzero.camw.quizzes.constants.QUIZ_EN_COLLECTION
import com.groundzero.camw.quizzes.constants.QUIZ_HR_COLLECTION
import com.groundzero.camw.utils.getJsonStoragePath
import org.springframework.stereotype.Component

@Component
class QuizRepository(private val readJson: ReadJson) {

    fun getQuizzesEnglish() = readJson.readJson<QuizCategory>(getJsonStoragePath(QUIZ_EN_COLLECTION))
    fun getQuizzesCroatian() = readJson.readJson<QuizCategory>(getJsonStoragePath(QUIZ_HR_COLLECTION))
}