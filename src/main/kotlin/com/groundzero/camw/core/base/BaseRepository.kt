package com.groundzero.camw.core.base

import com.groundzero.camw.core.data.DataType

interface BaseRepository<T> {

    fun getItems(dataType: DataType): List<T>?
    fun addItem(prayer: T, dataType: DataType): Boolean
    fun removeItem(prayer: T, dataType: DataType): Boolean
}