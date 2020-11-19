package com.groundzero.camw.core.cache.service

import com.groundzero.camw.core.service.NetworkService
import com.groundzero.camw.core.service.WriteJsonService
import com.groundzero.camw.features.adconfig.constants.AD_CONFIG_EN_COLLECTION
import com.groundzero.camw.features.adconfig.constants.AD_CONFIG_EN_COLLECTION_STAGING
import com.groundzero.camw.features.adconfig.constants.AD_CONFIG_HR_COLLECTION
import com.groundzero.camw.features.adconfig.constants.AD_CONFIG_HR_COLLECTION_STAGING
import com.groundzero.camw.features.adconfig.data.AdConfig
import com.groundzero.camw.features.adconfig.data.DataSnapshotToAdConfigMapper
import com.groundzero.camw.features.information.constants.INFORMATION_EN_COLLECTION
import com.groundzero.camw.features.information.constants.INFORMATION_EN_COLLECTION_STAGING
import com.groundzero.camw.features.information.constants.INFORMATION_HR_COLLECTION
import com.groundzero.camw.features.information.constants.INFORMATION_HR_COLLECTION_STAGING
import com.groundzero.camw.features.information.data.DataSnapshotToInformationBlockListMapper
import com.groundzero.camw.features.information.data.InformationBlock
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
import com.groundzero.camw.features.userreport.constants.USER_REPORT_EN_COLLECTION
import com.groundzero.camw.features.userreport.constants.USER_REPORT_EN_COLLECTION_STAGING
import com.groundzero.camw.features.userreport.constants.USER_REPORT_HR_COLLECTION
import com.groundzero.camw.features.userreport.constants.USER_REPORT_HR_COLLECTION_STAGING
import com.groundzero.camw.utils.getJsonLog
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import org.springframework.stereotype.Component

@Component
class CacheServiceImpl(
        private val networkService: NetworkService,
        private val writeJsonService: WriteJsonService,
        private val dataSnapshotToInformationBlockListMapper: DataSnapshotToInformationBlockListMapper,
        private val dataSnapshotToAdConfigMapper: DataSnapshotToAdConfigMapper
) : CacheService {

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
        updateDataFromRealtimeDatabase<InformationBlock>(INFORMATION_EN_COLLECTION)
        updateDataFromRealtimeDatabase<InformationBlock>(INFORMATION_HR_COLLECTION)
        updateDataFromRealtimeDatabase<InformationBlock>(INFORMATION_EN_COLLECTION_STAGING)
        updateDataFromRealtimeDatabase<InformationBlock>(INFORMATION_HR_COLLECTION_STAGING)
    }

    override fun updateAdConfig() {
        updateDataFromRealtimeDatabase<AdConfig>(AD_CONFIG_EN_COLLECTION)
        updateDataFromRealtimeDatabase<AdConfig>(AD_CONFIG_HR_COLLECTION)
        updateDataFromRealtimeDatabase<AdConfig>(AD_CONFIG_EN_COLLECTION_STAGING)
        updateDataFromRealtimeDatabase<AdConfig>(AD_CONFIG_HR_COLLECTION_STAGING)
    }

    override fun updateUserReports() {
        updateDataFromFirestore<Saint>(USER_REPORT_EN_COLLECTION)
        updateDataFromFirestore<Saint>(USER_REPORT_HR_COLLECTION)
        updateDataFromFirestore<Saint>(USER_REPORT_EN_COLLECTION_STAGING)
        updateDataFromFirestore<Saint>(USER_REPORT_HR_COLLECTION_STAGING)
    }

    private inline fun <reified T> updateDataFromFirestore(collectionKey: String) {
        with(collectionKey) {
            networkService.readFirestoreDatabase<T>(this)?.let {
                writeJsonService.writeList(this, it).getJsonLog(this)
            }
        }
    }

    private inline fun <reified T> updateDataFromRealtimeDatabase(collectionKey: String) {
        CoroutineScope(IO).launch {
            when (T::class.java) {
                InformationBlock::class.java -> {
                    val data = dataSnapshotToInformationBlockListMapper.map(networkService.readRealtimeDatabase(collectionKey))
                    writeJsonService.writeList(collectionKey, data).getJsonLog(collectionKey)
                }
                AdConfig::class.java -> {
                    val data = dataSnapshotToAdConfigMapper.map(networkService.readRealtimeDatabase(collectionKey))
                    writeJsonService.write(collectionKey, data).getJsonLog(collectionKey)
                }
            }
        }
    }
}