package com.groundzero.camw.thoughts.data

import com.groundzero.camw.data.ReadJson
import com.groundzero.camw.thoughts.constants.THOUGHT_EN_COLLECTION
import com.groundzero.camw.thoughts.constants.THOUGHT_HR_COLLECTION
import com.groundzero.camw.utils.getJsonStoragePath
import org.springframework.stereotype.Component

@Component
class ThoughtsRepository(private val readJson: ReadJson) {

    fun getThoughtsEnglish() = readJson.readJson<Thought>(getJsonStoragePath(THOUGHT_EN_COLLECTION))
    fun getThoughtsCroatian() = readJson.readJson<Thought>(getJsonStoragePath(THOUGHT_HR_COLLECTION))
}