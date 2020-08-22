package com.groundzero.camw.quizzes.data

data class QuizQuestionAnswer(
        val answer: String? = null,
        @field:JvmField
        val isCorrectAnswer: Boolean? = null,
        val itemId: String? = null
)