package com.groundzero.camw.quizzes.data

data class QuizQuestion(
        val image: String? = null,
        val itemId: String? = null,
        val question: String? = null,
        val answers: List<QuizQuestionAnswer>? = null
)