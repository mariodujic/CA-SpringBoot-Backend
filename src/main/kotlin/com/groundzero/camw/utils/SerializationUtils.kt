package com.groundzero.camw.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import org.springframework.stereotype.Component
import kotlin.reflect.full.memberProperties

@Component
@Suppress("declaration_cant_be_inlined")
class SerializationUtils {

    val mapper = ObjectMapper().apply {
        configure(SerializationFeature.INDENT_OUTPUT, true)
    }
}

inline fun <reified T : Any> T.asMap() : Map<String, String?> {
    val props = T::class.memberProperties.associateBy { it.name }
    return props.keys.associateWith { props[it]?.get(this).toString() }
}