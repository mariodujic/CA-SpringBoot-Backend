package com.groundzero.camw.features.quizzes.constants

import com.groundzero.camw.core.data.DataType

sealed class QuizDataType {
    object English : DataType.English(QUIZ_EN_COLLECTION)
    object EnglishStaging : DataType.EnglishStaging(QUIZ_EN_COLLECTION_STAGING)
    object Croatian : DataType.Croatian(QUIZ_HR_COLLECTION)
    object CroatianStaging : DataType.CroatianStaging(QUIZ_HR_COLLECTION_STAGING)
    object Slovak : DataType.Slovak(QUIZ_SK_COLLECTION)
    object SlovakStaging : DataType.SlovakStaging(QUIZ_SK_COLLECTION_STAGING)
}