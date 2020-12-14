package com.groundzero.camw.core.base

import com.groundzero.camw.core.data.DataType
import org.springframework.stereotype.Component

@Component
interface BaseConfigRepository<T> {

    fun getConfig(dataType: DataType): T?
    fun addConfig(item: T, dataType: DataType): Boolean
}