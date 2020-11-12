package com.groundzero.camw.features.information.data

import com.groundzero.camw.core.base.BaseContentRepository
import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.data.ItemMapper
import com.groundzero.camw.core.service.ReadJsonService
import com.groundzero.camw.core.service.WriteJsonService
import com.groundzero.camw.features.information.constants.InformationBlockDataType
import com.groundzero.camw.utils.isSubclassOf
import org.springframework.stereotype.Component

@Component
class InformationBlockContentRepository(private val readJson: ReadJsonService, private val writeJson: WriteJsonService, private val mapper: ItemMapper<InformationBlock>) : BaseContentRepository<InformationBlock> {

    override fun getItems(dataType: DataType): List<InformationBlock>? =
            validateDataPathAndStartAction(dataType, readJson.readList(dataType.path))

    override fun addItem(item: InformationBlock, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.writeList(dataType.path, mapper.addItem(item, getItems(dataType))))

    override fun removeItem(item: InformationBlock, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.writeList(dataType.path, mapper.removeItem(item, getItems(dataType))))

    private fun <T> validateDataPathAndStartAction(dataType: DataType, action: T): T = if (dataType.isSubclassOf(InformationBlockDataType::class)) {
        action
    } else throw IllegalArgumentException()
}