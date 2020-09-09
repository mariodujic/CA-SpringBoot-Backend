package com.groundzero.camw.prayers.constants

import com.groundzero.camw.core.data.DataType

sealed class PrayerDataType {
    class English : DataType.English(PRAYER_EN_COLLECTION)
    class EnglishStaging : DataType.EnglishStaging(PRAYER_EN_COLLECTION_STAGING)
    class Croatian : DataType.Croatian(PRAYER_HR_COLLECTION)
    class CroatianStaging : DataType.CroatianStaging(PRAYER_HR_COLLECTION_STAGING)
}