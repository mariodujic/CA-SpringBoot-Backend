package com.groundzero.camw.cachier

import com.groundzero.camw.data.ReadNetworkService
import com.groundzero.camw.data.WriteJsonService
import com.groundzero.camw.prayers.constants.PRAYER_EN_COLLECTION
import com.groundzero.camw.prayers.data.Prayer
import com.groundzero.camw.quizzes.constants.QUIZ_EN_COLLECTION
import com.groundzero.camw.quizzes.data.QuizCategory
import com.groundzero.camw.thoughts.constants.THOUGHT_EN_COLLECTION
import com.groundzero.camw.thoughts.data.Thought
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CacheRepository {

    @Autowired
    private lateinit var readNetworkService: ReadNetworkService

    @Autowired
    private lateinit var writeJsonService: WriteJsonService

    fun readNetworkQuizzes(): List<QuizCategory>? = readNetworkService.readDatabase(QUIZ_EN_COLLECTION)
    fun readNetworkPrayers(): List<Prayer>? = readNetworkService.readDatabase(PRAYER_EN_COLLECTION)
    fun readNetworkThoughts(): List<Thought>? = readNetworkService.readDatabase(THOUGHT_EN_COLLECTION)

    fun writeJsonQuizzes(quizzes: List<QuizCategory>): Boolean = writeJsonService.writeJson(getJsonPath(QUIZ_EN_COLLECTION), quizzes)
    fun writeJsonPrayers(prayers: List<Prayer>): Boolean = writeJsonService.writeJson(getJsonPath(PRAYER_EN_COLLECTION), prayers)
    fun writeJsonThoughts(thoughts: List<Thought>): Boolean = writeJsonService.writeJson(getJsonPath(THOUGHT_EN_COLLECTION), thoughts)

    private fun getJsonPath(collectionKey: String) = "src/main/resources/database/$collectionKey.json"
}