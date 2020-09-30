package com.groundzero.camw.features.quizzes.data

data class QuizQuestionAnswer(
        val answer: String? = null,
        @field:JvmField
        val isCorrectAnswer: Boolean? = null,
        val itemId: String? = null
)