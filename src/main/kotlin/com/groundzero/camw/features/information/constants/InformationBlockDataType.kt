package com.groundzero.camw.features.information.constants

import com.groundzero.camw.core.data.DataType


sealed class InformationBlockDataType {
    object English : DataType.English(INFORMATION_EN_COLLECTION)
    object EnglishStaging : DataType.EnglishStaging(INFORMATION_EN_COLLECTION_STAGING)
    object Croatian : DataType.Croatian(INFORMATION_HR_COLLECTION)
    object CroatianStaging : DataType.CroatianStaging(INFORMATION_HR_COLLECTION_STAGING)
}