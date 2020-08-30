package com.groundzero.camw.data

import com.fasterxml.jackson.module.kotlin.readValue
import com.groundzero.camw.utils.SerializationUtils
import org.springframework.stereotype.Component
import java.io.File

@Component
@Suppress("declaration_cant_be_inlined")
class ReadJsonService(val serialization: SerializationUtils) {
    fun <T> readJson(path: String): List<T>? = serialization.mapper.readValue(File(path))
}
