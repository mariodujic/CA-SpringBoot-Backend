package com.groundzero.camw.thoughts.data

import com.groundzero.camw.data.ReadJsonService
import com.groundzero.camw.thoughts.constants.THOUGHT_EN_COLLECTION
import com.groundzero.camw.thoughts.constants.THOUGHT_EN_COLLECTION_STAGING
import com.groundzero.camw.thoughts.constants.THOUGHT_HR_COLLECTION
import com.groundzero.camw.thoughts.constants.THOUGHT_HR_COLLECTION_STAGING
import org.springframework.stereotype.Component

@Component
class ThoughtsRepository(private val readJson: ReadJsonService) {

    fun getThoughtsEnglish() = readJson.read<Thought>(THOUGHT_EN_COLLECTION)
    fun getThoughtsEnglishStaging() = readJson.read<Thought>(THOUGHT_EN_COLLECTION_STAGING)
    fun getThoughtsCroatian() = readJson.read<Thought>(THOUGHT_HR_COLLECTION)
    fun getThoughtsCroatianStaging() = readJson.read<Thought>(THOUGHT_HR_COLLECTION_STAGING)
}