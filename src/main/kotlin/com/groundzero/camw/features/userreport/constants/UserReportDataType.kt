package com.groundzero.camw.features.userreport.constants

import com.groundzero.camw.core.data.DataType

sealed class UserReportDataType {
    object English : DataType.English(USER_REPORT_EN_COLLECTION)
    object EnglishStaging : DataType.EnglishStaging(USER_REPORT_EN_COLLECTION_STAGING)
    object Croatian : DataType.Croatian(USER_REPORT_HR_COLLECTION)
    object CroatianStaging : DataType.CroatianStaging(USER_REPORT_HR_COLLECTION_STAGING)
    object Slovak : DataType.Slovak(USER_REPORT_SK_COLLECTION)
    object SlovakStaging : DataType.SlovakStaging(USER_REPORT_SK_COLLECTION_STAGING)
    object Spanish : DataType.Spanish(USER_REPORT_ES_COLLECTION)
    object SpanishStaging : DataType.SpanishStaging(USER_REPORT_ES_COLLECTION_STAGING)
}