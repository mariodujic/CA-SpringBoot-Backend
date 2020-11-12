package com.groundzero.camw.features.adconfig.data

import com.google.firebase.database.DataSnapshot
import com.groundzero.camw.core.data.Mapper
import org.springframework.stereotype.Component

@Component
class DataSnapshotToAdConfigMapper : Mapper<DataSnapshot, AdConfig> {
    override fun map(data: DataSnapshot): AdConfig = data.getValue(AdConfig::class.java) ?: AdConfig()
}