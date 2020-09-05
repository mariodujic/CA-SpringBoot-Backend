package com.groundzero.camw.data

import com.groundzero.camw.utils.getJsonStoragePath
import org.springframework.stereotype.Component

@Component
class MiddlewareService<T>(
        private val readJsonService: ReadJsonService,
        private val writeJsonService: WriteJsonService
) {
    fun addItem(item: T, collectionPath: String) {
        val items: List<T>? = readJsonService.readJson(getJsonStoragePath(collectionPath))
        writeJsonService.writeJson(getJsonStoragePath(collectionPath), updateList(item, items))
    }

    private fun <T> updateList(item: T, list: List<T>?): List<T> = list?.let {
        it.toMutableList().apply {
            this.add(item)
        }
    } ?: mutableListOf(item)
}