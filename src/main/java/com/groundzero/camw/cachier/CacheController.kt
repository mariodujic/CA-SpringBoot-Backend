package com.groundzero.camw.cachier

import com.groundzero.camw.prayers.constants.PRAYER_EN_COLLECTION
import com.groundzero.camw.quizzes.constants.QUIZ_EN_COLLECTION
import com.groundzero.camw.thoughts.constants.THOUGHT_EN_COLLECTION
import com.groundzero.camw.utils.getJsonLog
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class CacheController : CommandLineRunner {

    @Autowired
    private lateinit var repository: CacheRepository


    override fun run(vararg args: String?) {
        readQuizzes()
        // readPrayers()
        // readThoughts()
    }

    private fun readQuizzes() = repository.readNetworkQuizzes()?.let { repository.writeJsonQuizzes(it).getJsonLog(QUIZ_EN_COLLECTION) }
    private fun readPrayers() = repository.readNetworkPrayers()?.let { repository.writeJsonPrayers(it).getJsonLog(PRAYER_EN_COLLECTION) }
    private fun readThoughts() = repository.readNetworkThoughts()?.let { repository.writeJsonThoughts(it).getJsonLog(THOUGHT_EN_COLLECTION) }
}