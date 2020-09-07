package com.groundzero.camw.thoughts.data

import com.groundzero.camw.data.DataType
import com.groundzero.camw.data.ItemMapper
import com.groundzero.camw.data.ReadJsonService
import com.groundzero.camw.data.WriteJsonService
import com.groundzero.camw.thoughts.constants.ThoughtDataType
import com.groundzero.camw.utils.isParentClass
import org.springframework.stereotype.Component

@Component
class ThoughtsRepository(private val readJson: ReadJsonService, private val writeJson: WriteJsonService, private val mapper: ItemMapper<Thought>) {

    fun getThoughts(dataType: DataType): List<Thought>? =
            validateDataPathAndStartAction(dataType, readJson.read(dataType.path))

    fun addThought(thought: Thought, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.write(dataType.path, mapper.addItem(thought, getThoughts(dataType))))

    private fun <T> validateDataPathAndStartAction(dataType: DataType, action: T): T = if (dataType.isParentClass(ThoughtDataType::class)) {
        action
    } else throw IllegalArgumentException()
}