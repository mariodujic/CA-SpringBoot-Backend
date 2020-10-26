package com.groundzero.camw.features.information.data

import com.google.firebase.database.DataSnapshot
import com.groundzero.camw.core.data.Mapper
import org.springframework.stereotype.Component

@Component
class DataSnapshotToInformationBlockListMapper : Mapper<DataSnapshot, List<InformationBlock>> {
    override fun map(data: DataSnapshot): List<InformationBlock> = data.children.map { it.getValue(InformationBlock::class.java) }
}