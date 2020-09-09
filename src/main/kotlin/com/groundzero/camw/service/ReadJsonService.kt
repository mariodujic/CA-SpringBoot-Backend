package com.groundzero.camw.service

import com.groundzero.camw.utils.SerializationUtils
import com.groundzero.camw.utils.getJsonStoragePath
import org.springframework.stereotype.Component
import java.io.File

@Component
@Suppress("declaration_cant_be_inlined")
class ReadJsonService(val serialization: SerializationUtils) {
    inline fun <reified T> read(path: String): List<T>? =
            serialization.mapper.readValue(
                    File(getJsonStoragePath(path)),
                    serialization.mapper.typeFactory.constructCollectionType(MutableList::class.java, T::class.java)
            )
}
