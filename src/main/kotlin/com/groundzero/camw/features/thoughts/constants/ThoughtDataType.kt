package com.groundzero.camw.features.thoughts.constants

import com.groundzero.camw.core.data.DataType

sealed class ThoughtDataType {
    object English : DataType.English(THOUGHT_EN_COLLECTION)
    object EnglishStaging : DataType.EnglishStaging(THOUGHT_EN_COLLECTION_STAGING)
    object Croatian : DataType.Croatian(THOUGHT_HR_COLLECTION)
    object CroatianStaging : DataType.CroatianStaging(THOUGHT_HR_COLLECTION_STAGING)
}