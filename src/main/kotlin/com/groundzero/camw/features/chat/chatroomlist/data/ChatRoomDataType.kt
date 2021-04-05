package com.groundzero.camw.features.chat.chatroomlist.data

import com.groundzero.camw.core.data.DataType

sealed class ChatRoomDataType {
    object English : DataType.English(CHAT_ROOM_EN_COLLECTION)
    object EnglishStaging : DataType.EnglishStaging(CHAT_ROOM_EN_COLLECTION_STAGING)
    object Croatian : DataType.Croatian(CHAT_ROOM_HR_COLLECTION)
    object CroatianStaging : DataType.CroatianStaging(CHAT_ROOM_HR_COLLECTION_STAGING)
    object Slovak : DataType.Slovak(CHAT_ROOM_SK_COLLECTION)
    object SlovakStaging : DataType.SlovakStaging(CHAT_ROOM_SK_COLLECTION_STAGING)
    object Spanish : DataType.Spanish(CHAT_ROOM_ES_COLLECTION)
    object SpanishStaging : DataType.SpanishStaging(CHAT_ROOM_ES_COLLECTION_STAGING)
}