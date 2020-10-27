package com.groundzero.camw.features.information.data

import com.groundzero.camw.core.base.BaseRepository
import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.data.ItemMapper
import com.groundzero.camw.core.service.ReadJsonService
import com.groundzero.camw.core.service.WriteJsonService
import com.groundzero.camw.features.information.constants.InformationBlockDataType
import com.groundzero.camw.utils.isSubclassOf
import org.springframework.stereotype.Component

@Component
class InformationBlockRepository(private val readJson: ReadJsonService, private val writeJson: WriteJsonService, private val mapper: ItemMapper<InformationBlock>) : BaseRepository<InformationBlock> {

    override fun getItems(dataType: DataType): List<InformationBlock>? =
            validateDataPathAndStartAction(dataType, readJson.read(dataType.path))

    override fun addItem(prayer: InformationBlock, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.write(dataType.path, mapper.addItem(prayer, getItems(dataType))))

    override fun removeItem(prayer: InformationBlock, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.write(dataType.path, mapper.removeItem(prayer, getItems(dataType))))

    private fun <T> validateDataPathAndStartAction(dataType: DataType, action: T): T = if (dataType.isSubclassOf(InformationBlockDataType::class)) {
        action
    } else throw IllegalArgumentException()
}