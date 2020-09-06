package com.groundzero.camw.quizzes.data

import com.groundzero.camw.data.NetworkModel

data class QuizCategory(
        override val itemId: String? = null,
        val text: String? = null,
        val title: String? = null,
        val quizzes: List<Quiz>? = null
) : NetworkModel