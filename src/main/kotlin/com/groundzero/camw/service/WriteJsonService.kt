package com.groundzero.camw.service

import com.groundzero.camw.utils.SerializationUtils
import com.groundzero.camw.utils.getJsonStoragePath
import org.springframework.stereotype.Component
import java.io.File

@Component
class WriteJsonService(private val serialization: SerializationUtils) {

    fun <T> write(path: String, list: List<T>): Boolean {
        return try {
            serialization.mapper.writeValue(File(getJsonStoragePath(path)), list)
            true
        } catch (e: Exception) {
            false
        }
    }
}