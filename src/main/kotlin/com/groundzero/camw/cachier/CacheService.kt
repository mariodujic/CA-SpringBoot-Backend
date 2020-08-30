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
        private val readNetworkService: ReadNetworkService,
        private val writeJson: WriteJsonService
) : Cache {

    override fun updateQuizzes() {
        updateData<QuizCategory>(QUIZ_EN_COLLECTION)
        updateData<QuizCategory>(QUIZ_HR_COLLECTION)
    }

    override fun updatePrayers() {
        updateData<Prayer>(PRAYER_EN_COLLECTION)
        updateData<Prayer>(PRAYER_HR_COLLECTION)
    }

    override fun updateThoughts() {
        updateData<Thought>(THOUGHT_EN_COLLECTION)
        updateData<Thought>(THOUGHT_HR_COLLECTION)
    }

    private inline fun <reified T> updateData(collectionKey: String) {
        with(collectionKey) {
            readNetworkService.readDatabase<T>(this)?.let { writeJson.writeJson(getJsonStoragePath(this), it).getJsonLog(this) }
        }
    }
}