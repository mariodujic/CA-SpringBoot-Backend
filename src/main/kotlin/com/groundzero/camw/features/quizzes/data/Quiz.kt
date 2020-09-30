package com.groundzero.camw.features.quizzes.data

data class Quiz(
        val image: String? = null,
        val itemId: String? = null,
        val text: String? = null,
        val title: String? = null,
        val questions: List<QuizQuestion>? = null
)