package com.groundzero.camw.features.quizzes.data

data class QuizQuestion(
        val image: String? = null,
        val itemId: String? = null,
        val question: String? = null,
        val answers: List<QuizQuestionAnswer>? = null
)