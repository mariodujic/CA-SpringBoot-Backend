package com.groundzero.camw.core.network

import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletResponse

@Component
class WriteHttpServletResponse(private val getSerializedNetworkResponse: GetSerializedNetworkResponse) {
    operator fun HttpServletResponse.invoke(networkResponse: NetworkResponse): HttpServletResponse = this.apply {
        contentType = "application/json";
        characterEncoding = "UTF-8";
        writer.write(getSerializedNetworkResponse(networkResponse))
    }
}