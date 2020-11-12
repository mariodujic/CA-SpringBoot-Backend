package com.groundzero.camw.features.adconfig.constants

import com.groundzero.camw.core.data.DataType

sealed class AdConfigDataType {
    object English : DataType.English(AD_CONFIG_EN_COLLECTION)
    object EnglishStaging : DataType.EnglishStaging(AD_CONFIG_EN_COLLECTION_STAGING)
    object Croatian : DataType.Croatian(AD_CONFIG_HR_COLLECTION)
    object CroatianStaging : DataType.CroatianStaging(AD_CONFIG_HR_COLLECTION_STAGING)
}