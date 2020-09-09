package com.groundzero.camw.thoughts.constants

import com.groundzero.camw.core.data.DataType

sealed class ThoughtDataType {
    class English : DataType.English(THOUGHT_EN_COLLECTION)
    class EnglishStaging : DataType.EnglishStaging(THOUGHT_EN_COLLECTION_STAGING)
    class Croatian : DataType.Croatian(THOUGHT_HR_COLLECTION)
    class CroatianStaging : DataType.CroatianStaging(THOUGHT_HR_COLLECTION_STAGING)
}