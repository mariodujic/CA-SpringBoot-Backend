package com.groundzero.camw.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.stereotype.Component

@Component
class SerializationUtils {

    val mapper = ObjectMapper().apply {
        configure(SerializationFeature.INDENT_OUTPUT, true)
    }
}