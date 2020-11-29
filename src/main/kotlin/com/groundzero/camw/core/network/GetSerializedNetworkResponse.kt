package com.groundzero.camw.core.network

import com.groundzero.camw.utils.SerializationUtils
import org.springframework.stereotype.Component

@Component
class GetSerializedNetworkResponse(private val serializationUtils: SerializationUtils) {

    operator fun invoke(networkResponse: NetworkResponse): String =
        serializationUtils.mapper.writeValueAsString(networkResponse)
}