package com.groundzero.camw.features.thoughts.data

import com.groundzero.camw.core.base.BaseContentRepository
import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.data.ItemMapper
import com.groundzero.camw.core.service.ReadJsonService
import com.groundzero.camw.core.service.WriteJsonService
import com.groundzero.camw.features.thoughts.constants.ThoughtDataType
import com.groundzero.camw.utils.isSubclassOf
import org.springframework.stereotype.Component

@Component
class ThoughtsContentRepository(private val readJson: ReadJsonService, private val writeJson: WriteJsonService, private val mapper: ItemMapper<Thought>) : BaseContentRepository<Thought> {

    override fun getItems(dataType: DataType): List<Thought>? =
            validateDataPathAndStartAction<List<Thought>?>(dataType, readJson.readList(dataType.path))?.sortedByDescending { it.date }

    override fun addItem(thought: Thought, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.writeList(dataType.path, mapper.addItem(thought, getItems(dataType))))

    override fun removeItem(thought: Thought, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.writeList(dataType.path, mapper.removeItem(thought, getItems(dataType))))

    private fun <T> validateDataPathAndStartAction(dataType: DataType, action: T): T = if (dataType.isSubclassOf(ThoughtDataType::class)) {
        action
    } else throw IllegalArgumentException()
}