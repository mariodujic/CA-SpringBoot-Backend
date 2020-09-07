package com.groundzero.camw.prayers.data

import com.groundzero.camw.data.DataType
import com.groundzero.camw.data.ItemMapper
import com.groundzero.camw.data.ReadJsonService
import com.groundzero.camw.data.WriteJsonService
import com.groundzero.camw.prayers.constants.PrayerDataType
import com.groundzero.camw.utils.isParentClass
import org.springframework.stereotype.Component

@Component
class PrayersRepository(private val readJson: ReadJsonService, private val writeJson: WriteJsonService, private val mapper: ItemMapper<Prayer>) {

    fun getPrayers(dataType: DataType): List<Prayer>? =
            validateDataPathAndStartAction(dataType, readJson.read(dataType.path))

    fun addPrayer(prayer: Prayer, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.write(dataType.path, mapper.addItem(prayer, getPrayers(dataType))))

    fun removePrayer(prayer: Prayer, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.write(dataType.path, mapper.removeItem(prayer, getPrayers(dataType))))

    private fun <T> validateDataPathAndStartAction(dataType: DataType, action: T): T = if (dataType.isParentClass(PrayerDataType::class)) {
        action
    } else throw IllegalArgumentException()
}