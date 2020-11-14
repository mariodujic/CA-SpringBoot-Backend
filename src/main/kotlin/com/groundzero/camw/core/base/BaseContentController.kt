package com.groundzero.camw.core.base

import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.network.NetworkResponse
import org.springframework.web.bind.annotation.RequestBody

open class BaseContentController<T>(private val baseContentRepository: BaseContentRepository<T>) {

    fun getItemsResponse(type: DataType): NetworkResponse {
        baseContentRepository.getItems(type)?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    fun removeItemResponse(@RequestBody item: T, type: DataType): NetworkResponse {
        return if (baseContentRepository.removeItem(item, type)) {
            val items = baseContentRepository.getItems(type)
            NetworkResponse.Success(200, "Success", items)
        } else {
            NetworkResponse.Error(404, "Error")
        }
    }

    fun addItemResponse(item: T, type: DataType): NetworkResponse {
        return if (baseContentRepository.addItem(item, type)) {
            val items = baseContentRepository.getItems(type)
            NetworkResponse.Success(200, "Success", items)
        } else {
            NetworkResponse.Error(404, "Error")
        }
    }
}