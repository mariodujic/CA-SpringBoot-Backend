package com.groundzero.camw.data

import com.fasterxml.jackson.module.kotlin.readValue
import com.groundzero.camw.utils.SerializationUtils
import java.io.File

open class ReadJson(open val serialization: SerializationUtils) {
    fun <T> readJson(path: String): List<T>? = serialization.mapper.readValue(File(path))
}