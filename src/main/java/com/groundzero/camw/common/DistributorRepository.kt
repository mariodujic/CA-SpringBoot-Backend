package com.groundzero.camw.common

import com.groundzero.camw.data.ReadJsonService
import com.groundzero.camw.prayers.constants.PRAYER_EN_COLLECTION
import com.groundzero.camw.prayers.data.Prayer
import com.groundzero.camw.quizzes.constants.QUIZ_EN_COLLECTION
import com.groundzero.camw.quizzes.data.QuizCategory
import com.groundzero.camw.thoughts.constants.THOUGHT_EN_COLLECTION
import com.groundzero.camw.thoughts.data.Thought
import com.groundzero.camw.utils.getJsonStoragePath
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class DistributorRepository {

    @Autowired
    private lateinit var readJsonService: ReadJsonService

    fun getPrayers() = readJsonService.readJson<Prayer>(getJsonStoragePath(PRAYER_EN_COLLECTION))
    fun getThoughts() = readJsonService.readJson<Thought>(getJsonStoragePath(THOUGHT_EN_COLLECTION))
    fun getQuizzes() = readJsonService.readJson<QuizCategory>(getJsonStoragePath(QUIZ_EN_COLLECTION))
}