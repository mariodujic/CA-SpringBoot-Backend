package com.groundzero.camw.cachier

import com.groundzero.camw.core.service.NetworkService
import com.groundzero.camw.core.service.WriteJsonService
import com.groundzero.camw.quizzes.constants.QUIZ_EN_COLLECTION
import com.groundzero.camw.quizzes.constants.QUIZ_EN_COLLECTION_STAGING
import com.groundzero.camw.quizzes.constants.QUIZ_HR_COLLECTION
import com.groundzero.camw.quizzes.constants.QUIZ_HR_COLLECTION_STAGING
import com.groundzero.camw.quizzes.data.QuizCategory
import com.groundzero.camw.utils.getJsonLog
import org.springframework.stereotype.Component

@Component
class CacheService(
        private val networkService: NetworkService,
        private val writeJsonService: WriteJsonService
) : Cache {

    override fun updateQuizzes() {
        updateData<QuizCategory>(QUIZ_EN_COLLECTION)
        updateData<QuizCategory>(QUIZ_HR_COLLECTION)
        updateData<QuizCategory>(QUIZ_EN_COLLECTION_STAGING)
        updateData<QuizCategory>(QUIZ_HR_COLLECTION_STAGING)
    }

    override fun updatePrayers() {/*
        updateData<Prayer>(PRAYER_EN_COLLECTION)
        updateData<Prayer>(PRAYER_HR_COLLECTION)
        updateData<Prayer>(PRAYER_EN_COLLECTION_STAGING)
        updateData<Prayer>(PRAYER_HR_COLLECTION_STAGING)*/
    }

    override fun updateThoughts() {/*
        updateData<Thought>(THOUGHT_EN_COLLECTION)
        updateData<Thought>(THOUGHT_HR_COLLECTION)
        updateData<Thought>(THOUGHT_EN_COLLECTION_STAGING)
        updateData<Thought>(THOUGHT_HR_COLLECTION_STAGING)*/
    }

    private inline fun <reified T> updateData(collectionKey: String) {
        with(collectionKey) {
            networkService.readDatabase<T>(this)?.let { writeJsonService.write(this, it).getJsonLog(this) }
        }
    }
}