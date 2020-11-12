package com.groundzero.camw.core.service

import com.groundzero.camw.utils.SerializationUtils
import com.groundzero.camw.utils.getJsonStoragePath
import org.springframework.stereotype.Component
import java.io.File
import java.io.FileNotFoundException


@Component
@Suppress("declaration_cant_be_inlined")
class ReadJsonService(val serialization: SerializationUtils) {

    inline fun <reified T> readList(path: String): List<T>? =
            try {
                serialization.mapper.readValue(
                        File(getJsonStoragePath(path)),
                        serialization.mapper.typeFactory.constructCollectionType(MutableList::class.java, T::class.java)
                )
            } catch (e: FileNotFoundException) {
                /**
                 * If file is not created and new data is being added, file will be created.
                 * @see WriteJsonService
                 */
                mutableListOf()
            }

    inline fun <reified T> read(path: String): T? =
            try {
                serialization.mapper.readValue(File(getJsonStoragePath(path)), T::class.java)
            } catch (e: FileNotFoundException) {
                null
            }
}
