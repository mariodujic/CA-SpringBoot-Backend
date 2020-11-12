package com.groundzero.camw.features.adconfig.data

import com.groundzero.camw.core.base.BaseConfigRepository
import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.service.ReadJsonService
import com.groundzero.camw.core.service.WriteJsonService
import com.groundzero.camw.features.adconfig.constants.AdConfigDataType
import com.groundzero.camw.utils.isSubclassOf
import org.springframework.stereotype.Component

@Component
class AdConfigRepository(private val readJson: ReadJsonService, private val writeJson: WriteJsonService) : BaseConfigRepository<AdConfig> {

    override fun getConfig(dataType: DataType): AdConfig? = validateDataPathAndStartAction(dataType, readJson.read(dataType.path))

    override fun addConfig(item: AdConfig, dataType: DataType): Boolean =
            validateDataPathAndStartAction(dataType, writeJson.write(dataType.path, item))

    private fun <T> validateDataPathAndStartAction(dataType: DataType, action: T): T = if (dataType.isSubclassOf(AdConfigDataType::class)) {
        action
    } else throw IllegalArgumentException()
}