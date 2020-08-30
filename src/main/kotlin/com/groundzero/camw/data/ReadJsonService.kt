package com.groundzero.camw.data

import com.fasterxml.jackson.module.kotlin.readValue
import com.groundzero.camw.utils.SerializationUtils
import org.springframework.stereotype.Component
import java.io.File

/**
 * 'inline' modifier is not allowed on virtual members
 */
@Component
class ReadJson(override val serialization: SerializationUtils) : ReadJsonImpl(serialization)

open class ReadJsonImpl(open val serialization: SerializationUtils) {
    fun <T> readJson(path: String): List<T>? = serialization.mapper.readValue(File(path))
}