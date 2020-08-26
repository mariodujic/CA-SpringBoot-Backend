package com.groundzero.camw.quizzes.data

data class QuizCategory(
        val itemId: String? = null,
        val text: String? = null,
        val title: String? = null,
        val quizzes: List<Quiz>? = null
)