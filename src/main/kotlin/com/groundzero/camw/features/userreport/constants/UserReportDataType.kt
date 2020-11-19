package com.groundzero.camw.features.userreport.constants

import com.groundzero.camw.core.data.DataType

sealed class UserReportDataType {
    object English : DataType.English(USER_REPORT_EN_COLLECTION)
    object EnglishStaging : DataType.EnglishStaging(USER_REPORT_EN_COLLECTION_STAGING)
    object Croatian : DataType.Croatian(USER_REPORT_HR_COLLECTION)
    object CroatianStaging : DataType.CroatianStaging(USER_REPORT_HR_COLLECTION_STAGING)
}