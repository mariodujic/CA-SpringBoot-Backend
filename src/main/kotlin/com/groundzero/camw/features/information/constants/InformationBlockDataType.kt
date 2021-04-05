package com.groundzero.camw.features.information.constants

import com.groundzero.camw.core.data.DataType


sealed class InformationBlockDataType {
    object English : DataType.English(INFORMATION_EN_COLLECTION)
    object EnglishStaging : DataType.EnglishStaging(INFORMATION_EN_COLLECTION_STAGING)
    object Croatian : DataType.Croatian(INFORMATION_HR_COLLECTION)
    object CroatianStaging : DataType.CroatianStaging(INFORMATION_HR_COLLECTION_STAGING)
    object Slovak : DataType.Slovak(INFORMATION_SK_COLLECTION)
    object SlovakStaging : DataType.SlovakStaging(INFORMATION_SK_COLLECTION_STAGING)
    object Spanish : DataType.Spanish(INFORMATION_ES_COLLECTION)
    object SpanishStaging : DataType.SpanishStaging(INFORMATION_ES_COLLECTION_STAGING)
}