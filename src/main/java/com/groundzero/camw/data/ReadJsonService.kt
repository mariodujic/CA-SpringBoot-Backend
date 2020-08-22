package com.groundzero.camw.data

import com.fasterxml.jackson.module.kotlin.readValue
import com.groundzero.camw.utils.SerializationUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.io.File

@Component
class ReadJsonService {

    @Autowired
    lateinit var serialization: SerializationUtils

    inline fun <reified T> readJson(path: String): List<T>? = serialization.mapper.readValue(File(path))
}