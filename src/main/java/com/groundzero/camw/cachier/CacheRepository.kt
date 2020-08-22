package com.groundzero.camw.cachier

import com.groundzero.camw.data.ReadNetworkService
import com.groundzero.camw.data.WriteJsonService
import com.groundzero.camw.prayers.constants.PRAYERS_ENGLISH_COLLECTION
import com.groundzero.camw.prayers.data.Prayer
import com.groundzero.camw.quizzes.constants.QUIZZES_ENGLISH_COLLECTION
import com.groundzero.camw.quizzes.data.QuizCategory
import com.groundzero.camw.thoughts.constants.THOUGHTS_ENGLISH_COLLECTION
import com.groundzero.camw.thoughts.data.Thought
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CacheRepository {

    @Autowired
    private lateinit var readNetworkService: ReadNetworkService

    @Autowired
    private lateinit var writeJsonService: WriteJsonService

    fun readNetworkQuizzes(): List<QuizCategory>? = readNetworkService.readDatabase()
    fun readNetworkPrayers(): List<Prayer>? = readNetworkService.readDatabase()
    fun readNetworkThoughts(): List<Thought>? = readNetworkService.readDatabase()

    fun writeJsonQuizzes(quizzes: List<QuizCategory>): Boolean = writeJsonService.writeJson(getJsonPath(QUIZZES_ENGLISH_COLLECTION), quizzes)
    fun writeJsonPrayers(prayers: List<Prayer>): Boolean = writeJsonService.writeJson(getJsonPath(PRAYERS_ENGLISH_COLLECTION), prayers)
    fun writeJsonThoughts(thoughts: List<Thought>): Boolean = writeJsonService.writeJson(getJsonPath(THOUGHTS_ENGLISH_COLLECTION), thoughts)

    private fun getJsonPath(collectionKey: String) = "src/main/resources/database/$collectionKey.json"
}