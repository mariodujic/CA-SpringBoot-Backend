package com.groundzero.camw.quizzes.data

data class Quiz(
        val image: String? = null,
        val itemId: String? = null,
        val text: String? = null,
        val title: String? = null,
        val questions: List<QuizQuestion>? = null
)