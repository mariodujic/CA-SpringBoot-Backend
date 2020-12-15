package com.groundzero.camw.features.chat.data

import com.groundzero.camw.core.base.BaseContentRepository
import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.data.ItemMapper
import com.groundzero.camw.core.service.ReadJsonService
import com.groundzero.camw.core.service.WriteJsonService
import com.groundzero.camw.utils.isSubclassOf
import org.springframework.stereotype.Component

@Component
class ChatRoomsRepository(
        private val readJson: ReadJsonService,
        private val writeJson: WriteJsonService,
        private val mapper: ItemMapper<ChatRoom>
) : BaseContentRepository<ChatRoom> {

    override fun getItems(dataType: DataType): List<ChatRoom>? =
            validateDataPathAndStartAction(dataType, readJson.readList(dataType.path))

    override fun addItem(chatRoom: ChatRoom, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.writeList(dataType.path, mapper.addItem(chatRoom, getItems(dataType))))

    override fun removeItem(chatRoom: ChatRoom, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.writeList(dataType.path, mapper.removeItem(chatRoom, getItems(dataType))))

    private fun <T> validateDataPathAndStartAction(dataType: DataType, action: T): T = if (dataType.isSubclassOf(ChatRoomDataType::class)) {
        action
    } else throw IllegalArgumentException()
}