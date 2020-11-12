package com.groundzero.camw.core.service

import com.groundzero.camw.utils.SerializationUtils
import com.groundzero.camw.utils.getJsonStoragePath
import org.springframework.stereotype.Component
import java.io.File

@Component
class WriteJsonService(private val serialization: SerializationUtils) {

    fun <T> writeList(path: String, list: List<T>): Boolean {
        return try {
            serialization.mapper.writeValue(File(getJsonStoragePath(path)), list)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun <T> write(path: String, data: T): Boolean {
        return try {
            serialization.mapper.writeValue(File(getJsonStoragePath(path)), data)
            true
        } catch (e: Exception) {
            false
        }
    }
}