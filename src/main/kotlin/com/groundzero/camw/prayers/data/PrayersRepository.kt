package com.groundzero.camw.prayers.data

import com.groundzero.camw.data.ItemMapper
import com.groundzero.camw.data.ReadJsonService
import com.groundzero.camw.data.WriteJsonService
import com.groundzero.camw.prayers.constants.PRAYER_EN_COLLECTION
import com.groundzero.camw.prayers.constants.PRAYER_EN_COLLECTION_STAGING
import com.groundzero.camw.prayers.constants.PRAYER_HR_COLLECTION
import com.groundzero.camw.prayers.constants.PRAYER_HR_COLLECTION_STAGING
import org.springframework.stereotype.Component

@Component
class PrayersRepository(private val readJson: ReadJsonService, private val writeJson: WriteJsonService, private val mapper: ItemMapper<Prayer>) {

    fun getPrayersEnglish() = readJson.read<Prayer>(PRAYER_EN_COLLECTION)
    fun getPrayersEnglishStaging() = readJson.read<Prayer>(PRAYER_EN_COLLECTION_STAGING)
    fun getPrayersCroatian() = readJson.read<Prayer>(PRAYER_HR_COLLECTION)
    fun getPrayersCroatianStaging() = readJson.read<Prayer>(PRAYER_HR_COLLECTION_STAGING)

    fun addPrayerEnglishStaging(prayer: Prayer) =
            writeJson.write(PRAYER_EN_COLLECTION_STAGING, mapper.addItem(prayer, getPrayersEnglishStaging()))
}