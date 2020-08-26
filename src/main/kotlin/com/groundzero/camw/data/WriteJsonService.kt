package com.groundzero.camw.data

import com.groundzero.camw.utils.SerializationUtils
import org.springframework.stereotype.Component
import java.io.File

@Component
class WriteJsonService(private val serialization: SerializationUtils) {

    fun <T> writeJson(path: String, list: List<T>): Boolean {
        return try {
            serialization.mapper.writeValue(File((path)), list)
            true
        } catch (e: Exception) {
            false
        }
    }
}