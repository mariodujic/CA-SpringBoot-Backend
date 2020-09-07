package com.groundzero.camw.data

import org.springframework.stereotype.Component

@Component
class ItemMapper<T : NetworkModel> {

    fun addItem(item: T, list: List<T>?): List<T> = list?.let {
        return if (itemExists(item, list)) {
            replaceItemList(item, list)
        } else {
            addItemList(item, list)
        }
    } ?: mutableListOf(item)

    fun removeItem(item: T, list: List<T>?): List<T> = list?.let {
        if (itemExists(item, it)) {
            return removeItemList(item, list)
        } else {
            it
        }
    } ?: mutableListOf(item)

    private fun replaceItemList(item: T, list: List<T>) = list.map { t: T -> if (t.itemId == item.itemId) item else t }
    private fun removeItemList(item: T, list: List<T>) = list.filter { t -> t.itemId != item.itemId }
    private fun addItemList(item: T, list: List<T>) = list.toMutableList().apply { add(item) }
    private fun itemExists(item: T, list: List<T>?) = list?.indexOfFirst { t -> t.itemId == item.itemId } != -1
}