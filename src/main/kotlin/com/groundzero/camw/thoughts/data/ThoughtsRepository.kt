package com.groundzero.camw.thoughts.data

import com.groundzero.camw.data.ReadJsonService
import com.groundzero.camw.thoughts.constants.THOUGHT_EN_COLLECTION
import com.groundzero.camw.thoughts.constants.THOUGHT_EN_COLLECTION_STAGING
import com.groundzero.camw.thoughts.constants.THOUGHT_HR_COLLECTION
import com.groundzero.camw.thoughts.constants.THOUGHT_HR_COLLECTION_STAGING
import com.groundzero.camw.utils.getJsonStoragePath
import org.springframework.stereotype.Component

@Component
class ThoughtsRepository(private val readJsonService: ReadJsonService) {

    fun getThoughtsEnglish() = readJsonService.readJson<Thought>(getJsonStoragePath(THOUGHT_EN_COLLECTION))
    fun getThoughtsEnglishStaging() = readJsonService.readJson<Thought>(getJsonStoragePath(THOUGHT_EN_COLLECTION_STAGING))
    fun getThoughtsCroatian() = readJsonService.readJson<Thought>(getJsonStoragePath(THOUGHT_HR_COLLECTION))
    fun getThoughtsCroatianStaging() = readJsonService.readJson<Thought>(getJsonStoragePath(THOUGHT_HR_COLLECTION_STAGING))
}