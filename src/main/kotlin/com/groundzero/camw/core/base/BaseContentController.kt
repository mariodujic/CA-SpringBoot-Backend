package com.groundzero.camw.core.base

import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.network.NetworkResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestBody

open class BaseContentController<T>(private val baseContentRepository: BaseContentRepository<T>) {

    fun getItemsResponse(type: DataType): NetworkResponse {
        baseContentRepository.getItems(type)?.let {
            return NetworkResponse.Success(HttpStatus.OK.value(), "Success", it)
        }
        return NetworkResponse.Error(HttpStatus.NOT_FOUND.value(), "Error")
    }

    fun removeItemResponse(@RequestBody item: T, type: DataType): NetworkResponse {
        return if (baseContentRepository.removeItem(item, type)) {
            val items = baseContentRepository.getItems(type)
            NetworkResponse.Success(HttpStatus.OK.value(), "Success", items)
        } else {
            NetworkResponse.Error(HttpStatus.NOT_FOUND.value(), "Error")
        }
    }

    fun addItemResponse(item: T, type: DataType): NetworkResponse {
        return if (baseContentRepository.addItem(item, type)) {
            val items = baseContentRepository.getItems(type)
            NetworkResponse.Success(HttpStatus.OK.value(), "Success", items)
        } else {
            NetworkResponse.Error(HttpStatus.NOT_FOUND.value(), "Error")
        }
    }
}