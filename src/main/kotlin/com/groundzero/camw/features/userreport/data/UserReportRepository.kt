package com.groundzero.camw.features.userreport.data

import com.groundzero.camw.core.base.BaseContentRepository
import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.data.ItemMapper
import com.groundzero.camw.core.service.ReadJsonService
import com.groundzero.camw.core.service.WriteJsonService
import com.groundzero.camw.features.userreport.constants.UserReportDataType
import com.groundzero.camw.utils.isSubclassOf
import org.springframework.stereotype.Component

@Component
class UserReportRepository(private val readJson: ReadJsonService, private val writeJson: WriteJsonService, private val mapper: ItemMapper<UserReport>) : BaseContentRepository<UserReport> {

    override fun getItems(dataType: DataType): List<UserReport>? =
            validateDataPathAndStartAction(dataType, readJson.readList(dataType.path))

    override fun addItem(report: UserReport, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.writeList(dataType.path, mapper.addItem(report, getItems(dataType))))

    override fun removeItem(report: UserReport, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.writeList(dataType.path, mapper.removeItem(report, getItems(dataType))))

    private fun <T> validateDataPathAndStartAction(dataType: DataType, action: T): T = if (dataType.isSubclassOf(UserReportDataType::class)) {
        action
    } else throw IllegalArgumentException()
}