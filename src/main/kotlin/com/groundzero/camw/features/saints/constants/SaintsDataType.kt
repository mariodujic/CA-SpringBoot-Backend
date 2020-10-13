package com.groundzero.camw.features.saints.constants

import com.groundzero.camw.core.data.DataType

sealed class SaintsDataType {
    object English : DataType.English(SAINTS_EN_COLLECTION)
    object EnglishStaging : DataType.EnglishStaging(SAINTS_EN_COLLECTION_STAGING)
    object Croatian : DataType.Croatian(SAINTS_HR_COLLECTION)
    object CroatianStaging : DataType.CroatianStaging(SAINTS_HR_COLLECTION_STAGING)
}