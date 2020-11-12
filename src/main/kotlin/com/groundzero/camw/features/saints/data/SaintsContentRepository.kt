package com.groundzero.camw.features.saints.data

import com.groundzero.camw.core.base.BaseContentRepository
import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.data.ItemMapper
import com.groundzero.camw.core.service.ReadJsonService
import com.groundzero.camw.core.service.WriteJsonService
import com.groundzero.camw.features.saints.constants.SaintsDataType
import com.groundzero.camw.utils.isSubclassOf
import org.springframework.stereotype.Component

@Component
class SaintsContentRepository(
        private val readJson: ReadJsonService,
        private val writeJson: WriteJsonService,
        private val mapper: ItemMapper<Saint>,
        private val saintsSort: SaintsSort
) : BaseContentRepository<Saint> {

    override fun getItems(dataType: DataType): List<Saint>? {
        val saints: List<Saint>? = validateDataPathAndStartAction(dataType, readJson.readList(dataType.path))
        return saintsSort.map(saints)
    }

    override fun addItem(saint: Saint, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.writeList(dataType.path, mapper.addItem(saint, getItems(dataType))))

    override fun removeItem(saint: Saint, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.writeList(dataType.path, mapper.removeItem(saint, getItems(dataType))))

    private fun <T> validateDataPathAndStartAction(dataType: DataType, action: T): T = if (dataType.isSubclassOf(SaintsDataType::class)) {
        action
    } else throw IllegalArgumentException()
}