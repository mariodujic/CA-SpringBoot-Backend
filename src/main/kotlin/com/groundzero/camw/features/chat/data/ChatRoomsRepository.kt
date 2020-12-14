package com.groundzero.camw.features.chat.data

import com.groundzero.camw.core.base.BaseConfigRepository
import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.service.ReadJsonService
import com.groundzero.camw.core.service.WriteJsonService
import com.groundzero.camw.utils.isSubclassOf
import org.springframework.stereotype.Component

@Component
class ChatRoomsRepository(private val readJson: ReadJsonService, private val writeJson: WriteJsonService) : BaseConfigRepository<List<ChatRoom>> {

    override fun getConfig(dataType: DataType): List<ChatRoom>? = validateDataPathAndStartAction(dataType, readJson.read(dataType.path))

    override fun addConfig(item: List<ChatRoom>, dataType: DataType): Boolean =
            validateDataPathAndStartAction(dataType, writeJson.write(dataType.path, item))

    private fun <T> validateDataPathAndStartAction(dataType: DataType, action: T): T = if (dataType.isSubclassOf(ChatRoomDataType::class)) {
        action
    } else throw IllegalArgumentException()
}