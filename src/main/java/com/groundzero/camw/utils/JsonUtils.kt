package com.groundzero.camw.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.stereotype.Component
import java.io.File

@Component
class JsonUtils {

    private val objectMapper = ObjectMapper().apply {
        configure(SerializationFeature.INDENT_OUTPUT, true)
    }

    fun <T> writeJson(path: String, list: List<T>) {
        objectMapper.writeValue(File((path)), list)
    }
}