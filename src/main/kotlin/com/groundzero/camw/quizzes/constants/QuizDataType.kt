package com.groundzero.camw.quizzes.constants

import com.groundzero.camw.core.data.DataType

sealed class QuizDataType {
    class English : DataType.English(QUIZ_EN_COLLECTION)
    class EnglishStaging : DataType.EnglishStaging(QUIZ_EN_COLLECTION_STAGING)
    class Croatian : DataType.Croatian(QUIZ_HR_COLLECTION)
    class CroatianStaging : DataType.CroatianStaging(QUIZ_HR_COLLECTION_STAGING)
}