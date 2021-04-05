package com.groundzero.camw.features.saints.constants

import com.groundzero.camw.core.data.DataType

sealed class SaintsDataType {
    object English : DataType.English(SAINTS_EN_COLLECTION)
    object EnglishStaging : DataType.EnglishStaging(SAINTS_EN_COLLECTION_STAGING)
    object Croatian : DataType.Croatian(SAINTS_HR_COLLECTION)
    object CroatianStaging : DataType.CroatianStaging(SAINTS_HR_COLLECTION_STAGING)
    object Slovak : DataType.Slovak(SAINTS_SK_COLLECTION)
    object SlovakStaging : DataType.SlovakStaging(SAINTS_SK_COLLECTION_STAGING)
    object Spanish : DataType.Spanish(SAINTS_ES_COLLECTION)
    object SpanishStaging : DataType.SpanishStaging(SAINTS_ES_COLLECTION_STAGING)
}