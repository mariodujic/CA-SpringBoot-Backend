package com.groundzero.camw.features.saints.data

import com.groundzero.camw.core.data.NullableMapper
import org.springframework.stereotype.Component

@Component
class SaintsSort : NullableMapper<List<Saint>?, List<Saint>?> {
    override fun map(data: List<Saint>?): List<Saint>? = data?.sortedBy { it.title }
}