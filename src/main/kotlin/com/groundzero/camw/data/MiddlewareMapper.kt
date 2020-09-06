package com.groundzero.camw.data

import org.springframework.stereotype.Component

@Component
class MiddlewareMapper<T : NetworkModel> {

    fun <T> addItem(item: T, list: List<T>?): List<T> = list?.let {
        it.toMutableList().apply {
            this.add(item)
        }
    } ?: mutableListOf(item)

    fun replaceItem(item: T, list: List<T>) = list.map { t: T -> if (t.itemId == item.itemId) item else t }
    fun itemExists(item: T, list: List<T>?) = list?.indexOfFirst { t -> t.itemId == item.itemId } != -1
}