package com.groundzero.camw.prayers.data

import com.groundzero.camw.data.ReadJson
import com.groundzero.camw.prayers.constants.PRAYER_EN_COLLECTION
import com.groundzero.camw.prayers.constants.PRAYER_HR_COLLECTION
import com.groundzero.camw.utils.getJsonStoragePath
import org.springframework.stereotype.Component

@Component
class PrayersRepository(private val readJson: ReadJson) {

    fun getPrayersEnglish() = readJson.readJson<Prayer>(getJsonStoragePath(PRAYER_EN_COLLECTION))
    fun getPrayersCroatian() = readJson.readJson<Prayer>(getJsonStoragePath(PRAYER_HR_COLLECTION))
}