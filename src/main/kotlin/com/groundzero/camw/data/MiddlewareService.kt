package com.groundzero.camw.data

import com.groundzero.camw.utils.getJsonStoragePath
import org.springframework.stereotype.Component

@Component
class MiddlewareService<in T : NetworkModel>(
        private val readJsonService: ReadJsonService,
        private val writeJsonService: WriteJsonService,
        private val middlewareMapper: MiddlewareMapper<T>
) {
    fun addItem(item: T, collectionPath: String) {

        with(cachedList(collectionPath)) {
            if (middlewareMapper.itemExists(item, this)) {
                middlewareMapper.addItem(item, this)
            } else {
                middlewareMapper.replaceItem(item, this!!)
            }.apply {
                writeJsonService.writeJson(getJsonStoragePath(collectionPath), this)
            }
        }
    }

    private fun cachedList(collectionPath: String): List<T>? = readJsonService.readJson(getJsonStoragePath(collectionPath))
}