package com.groundzero.camw.core.cache

import com.groundzero.camw.core.service.NetworkService
import com.groundzero.camw.core.service.WriteJsonService
import com.groundzero.camw.features.information.constants.INFORMATION_EN_COLLECTION
import com.groundzero.camw.features.information.constants.INFORMATION_EN_COLLECTION_STAGING
import com.groundzero.camw.features.information.constants.INFORMATION_HR_COLLECTION
import com.groundzero.camw.features.information.constants.INFORMATION_HR_COLLECTION_STAGING
import com.groundzero.camw.features.information.data.DataSnapshotToInformationBlockListMapper
import com.groundzero.camw.features.prayers.constants.PRAYER_EN_COLLECTION
import com.groundzero.camw.features.prayers.constants.PRAYER_EN_COLLECTION_STAGING
import com.groundzero.camw.features.prayers.constants.PRAYER_HR_COLLECTION
import com.groundzero.camw.features.prayers.constants.PRAYER_HR_COLLECTION_STAGING
import com.groundzero.camw.features.prayers.data.Prayer
import com.groundzero.camw.features.quizzes.constants.QUIZ_EN_COLLECTION
import com.groundzero.camw.features.quizzes.constants.QUIZ_EN_COLLECTION_STAGING
import com.groundzero.camw.features.quizzes.constants.QUIZ_HR_COLLECTION
import com.groundzero.camw.features.quizzes.constants.QUIZ_HR_COLLECTION_STAGING
import com.groundzero.camw.features.quizzes.data.QuizCategory
import com.groundzero.camw.features.saints.constants.SAINTS_EN_COLLECTION
import com.groundzero.camw.features.saints.constants.SAINTS_EN_COLLECTION_STAGING
import com.groundzero.camw.features.saints.constants.SAINTS_HR_COLLECTION
import com.groundzero.camw.features.saints.constants.SAINTS_HR_COLLECTION_STAGING
import com.groundzero.camw.features.saints.data.Saint
import com.groundzero.camw.features.thoughts.constants.THOUGHT_EN_COLLECTION
import com.groundzero.camw.features.thoughts.constants.THOUGHT_EN_COLLECTION_STAGING
import com.groundzero.camw.features.thoughts.constants.THOUGHT_HR_COLLECTION
import com.groundzero.camw.features.thoughts.constants.THOUGHT_HR_COLLECTION_STAGING
import com.groundzero.camw.features.thoughts.data.Thought
import com.groundzero.camw.utils.getJsonLog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import org.springframework.stereotype.Component

@Component
class CacheService(
        private val networkService: NetworkService,
        private val writeJsonService: WriteJsonService,
        private val dataSnapshotToInformationBlockListMapper: DataSnapshotToInformationBlockListMapper
) : Cache {

    override fun updateQuizzes() {
        updateDataFromFirestore<QuizCategory>(QUIZ_EN_COLLECTION)
        updateDataFromFirestore<QuizCategory>(QUIZ_HR_COLLECTION)
        updateDataFromFirestore<QuizCategory>(QUIZ_EN_COLLECTION_STAGING)
        updateDataFromFirestore<QuizCategory>(QUIZ_HR_COLLECTION_STAGING)
    }

    override fun updatePrayers() {
        updateDataFromFirestore<Prayer>(PRAYER_EN_COLLECTION)
        updateDataFromFirestore<Prayer>(PRAYER_HR_COLLECTION)
        updateDataFromFirestore<Prayer>(PRAYER_EN_COLLECTION_STAGING)
        updateDataFromFirestore<Prayer>(PRAYER_HR_COLLECTION_STAGING)
    }

    override fun updateThoughts() {
        updateDataFromFirestore<Thought>(THOUGHT_EN_COLLECTION)
        updateDataFromFirestore<Thought>(THOUGHT_HR_COLLECTION)
        updateDataFromFirestore<Thought>(THOUGHT_EN_COLLECTION_STAGING)
        updateDataFromFirestore<Thought>(THOUGHT_HR_COLLECTION_STAGING)
    }

    override fun updateSaints() {
        updateDataFromFirestore<Saint>(SAINTS_EN_COLLECTION)
        updateDataFromFirestore<Saint>(SAINTS_HR_COLLECTION)
        updateDataFromFirestore<Saint>(SAINTS_EN_COLLECTION_STAGING)
        updateDataFromFirestore<Saint>(SAINTS_HR_COLLECTION_STAGING)
    }

    override fun updateInformation() {
        updateDataFromRealtimeDatabase(INFORMATION_EN_COLLECTION)
        updateDataFromRealtimeDatabase(INFORMATION_HR_COLLECTION)
        updateDataFromRealtimeDatabase(INFORMATION_EN_COLLECTION_STAGING)
        updateDataFromRealtimeDatabase(INFORMATION_HR_COLLECTION_STAGING)
    }

    private inline fun <reified T> updateDataFromFirestore(collectionKey: String) {
        with(collectionKey) {
            networkService.readFirestoreDatabase<T>(this)?.let {
                writeJsonService.write(this, it).getJsonLog(this)
            }
        }
    }

    private fun updateDataFromRealtimeDatabase(collectionKey: String) {
        CoroutineScope(IO).launch {
            val informationBlocks = dataSnapshotToInformationBlockListMapper.map(networkService.readRealtimeDatabase(collectionKey))
            writeJsonService.write(collectionKey, informationBlocks).getJsonLog(collectionKey)
        }
    }
}