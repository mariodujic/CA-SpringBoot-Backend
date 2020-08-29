package com.groundzero.camw.cachier

import com.groundzero.camw.data.ReadNetworkService
import com.groundzero.camw.data.WriteJsonService
import com.groundzero.camw.prayers.constants.PRAYER_EN_COLLECTION
import com.groundzero.camw.prayers.constants.PRAYER_HR_COLLECTION
import com.groundzero.camw.prayers.data.Prayer
import com.groundzero.camw.quizzes.constants.QUIZ_EN_COLLECTION
import com.groundzero.camw.quizzes.constants.QUIZ_HR_COLLECTION
import com.groundzero.camw.quizzes.data.QuizCategory
import com.groundzero.camw.thoughts.constants.THOUGHT_EN_COLLECTION
import com.groundzero.camw.thoughts.constants.THOUGHT_HR_COLLECTION
import com.groundzero.camw.thoughts.data.Thought
import com.groundzero.camw.utils.getJsonLog
import com.groundzero.camw.utils.getJsonStoragePath
import org.springframework.stereotype.Component

@Component
class CacheService(
        private val readNetwork: ReadNetworkService,
        private val writeJson: WriteJsonService
) : Cache {

    override fun updateQuizzes() {
        readNetwork.readDatabase<QuizCategory>(QUIZ_EN_COLLECTION)?.let { writeJson.writeJson(getJsonStoragePath(QUIZ_EN_COLLECTION), it).getJsonLog(QUIZ_EN_COLLECTION) }
        readNetwork.readDatabase<QuizCategory>(QUIZ_HR_COLLECTION)?.let { writeJson.writeJson(getJsonStoragePath(QUIZ_HR_COLLECTION), it).getJsonLog(QUIZ_HR_COLLECTION) }
    }

    override fun updatePrayers() {
        readNetwork.readDatabase<Prayer>(PRAYER_EN_COLLECTION)?.let { writeJson.writeJson(getJsonStoragePath(PRAYER_EN_COLLECTION), it).getJsonLog(PRAYER_EN_COLLECTION) }
        readNetwork.readDatabase<Prayer>(PRAYER_HR_COLLECTION)?.let { writeJson.writeJson(getJsonStoragePath(PRAYER_HR_COLLECTION), it).getJsonLog(PRAYER_HR_COLLECTION) }
    }

    override fun updateThoughts() {
        readNetwork.readDatabase<Thought>(THOUGHT_EN_COLLECTION)?.let { writeJson.writeJson(getJsonStoragePath(THOUGHT_EN_COLLECTION), it).getJsonLog(THOUGHT_EN_COLLECTION) }
        readNetwork.readDatabase<Thought>(THOUGHT_HR_COLLECTION)?.let { writeJson.writeJson(getJsonStoragePath(THOUGHT_HR_COLLECTION), it).getJsonLog(THOUGHT_HR_COLLECTION) }
    }
}