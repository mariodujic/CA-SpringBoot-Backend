package com.groundzero.camw.core.base

import com.groundzero.camw.core.data.DataType

interface BaseContentRepository<T> {

    fun getItems(dataType: DataType): List<T>?
    fun addItem(item: T, dataType: DataType): Boolean
    fun removeItem(item: T, dataType: DataType): Boolean
}