package com.groundzero.camw.data

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.stereotype.Component
import java.io.File

@Component
class WriteJsonService {

    fun <T> writeJson(path: String, list: List<T>): Boolean {
        return try {
            objectMapper.writeValue(File((path)), list)
            true
        } catch (e: Exception) {
            false
        }
    }

    private val objectMapper = ObjectMapper().apply {
        configure(SerializationFeature.INDENT_OUTPUT, true)
    }
}