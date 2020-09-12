package com.groundzero.camw.prayers.constants

import com.groundzero.camw.core.data.DataType

sealed class PrayerDataType {
    object English : DataType.English(PRAYER_EN_COLLECTION)
    object EnglishStaging : DataType.EnglishStaging(PRAYER_EN_COLLECTION_STAGING)
    object Croatian : DataType.Croatian(PRAYER_HR_COLLECTION)
    object CroatianStaging : DataType.CroatianStaging(PRAYER_HR_COLLECTION_STAGING)
}