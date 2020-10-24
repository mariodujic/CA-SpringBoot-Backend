package com.groundzero.camw.features.prayers.data

import com.groundzero.camw.core.base.BaseRepository
import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.data.ItemMapper
import com.groundzero.camw.core.service.ReadJsonService
import com.groundzero.camw.core.service.WriteJsonService
import com.groundzero.camw.features.prayers.constants.PrayerDataType
import com.groundzero.camw.utils.isSubclassOf
import org.springframework.stereotype.Component

@Component
class PrayersRepository(private val readJson: ReadJsonService, private val writeJson: WriteJsonService, private val mapper: ItemMapper<Prayer>): BaseRepository<Prayer> {

    override fun getItems(dataType: DataType): List<Prayer>? =
            validateDataPathAndStartAction(dataType, readJson.read(dataType.path))

    override fun addItem(prayer: Prayer, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.write(dataType.path, mapper.addItem(prayer, getItems(dataType))))

    override fun removeItem(prayer: Prayer, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.write(dataType.path, mapper.removeItem(prayer, getItems(dataType))))

    private fun <T> validateDataPathAndStartAction(dataType: DataType, action: T): T = if (dataType.isSubclassOf(PrayerDataType::class)) {
        action
    } else throw IllegalArgumentException()
}