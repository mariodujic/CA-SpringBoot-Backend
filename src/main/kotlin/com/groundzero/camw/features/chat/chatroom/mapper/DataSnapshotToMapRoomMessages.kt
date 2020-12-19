package com.groundzero.camw.features.chat.chatroom.mapper

import com.google.firebase.database.DataSnapshot
import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageResponse
import org.springframework.stereotype.Component

@Component
class DataSnapshotToMapRoomMessages: Mapper<DataSnapshot, Map<String, List<ChatRoomMessageResponse>>> {

    override fun map(data: DataSnapshot): Map<String, List<ChatRoomMessageResponse>> =
        data.value as? Map<String, List<ChatRoomMessageResponse>> ?: emptyMap()

}