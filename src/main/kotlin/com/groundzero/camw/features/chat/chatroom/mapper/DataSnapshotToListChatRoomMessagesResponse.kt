package com.groundzero.camw.features.chat.chatroom.mapper

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.GenericTypeIndicator
import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.features.chat.chatroom.data.ChatRoomMessages
import org.springframework.stereotype.Component
import java.util.ArrayList

@Component
class DataSnapshotToListChatRoomMessagesResponse : Mapper<DataSnapshot, List<ChatRoomMessages>> {

    override fun map(data: DataSnapshot): List<ChatRoomMessages> {
        val type = object : GenericTypeIndicator<ArrayList<ChatRoomMessages>>() {}
        return data.getValue(type) ?: emptyList()
    }
}