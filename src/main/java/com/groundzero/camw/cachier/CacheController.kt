package com.groundzero.camw.cachier

import com.groundzero.camw.prayers.constants.PRAYERS_ENGLISH_COLLECTION
import com.groundzero.camw.quizzes.constants.QUIZZES_ENGLISH_COLLECTION
import com.groundzero.camw.thoughts.constants.THOUGHTS_ENGLISH_COLLECTION
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

    private fun readQuizzes() = repository.readNetworkQuizzes()?.let { repository.writeJsonQuizzes(it).getJsonLog(QUIZZES_ENGLISH_COLLECTION) }
    private fun readPrayers() = repository.readNetworkPrayers()?.let { repository.writeJsonPrayers(it).getJsonLog(PRAYERS_ENGLISH_COLLECTION) }
    private fun readThoughts() = repository.readNetworkThoughts()?.let { repository.writeJsonThoughts(it).getJsonLog(THOUGHTS_ENGLISH_COLLECTION) }
}