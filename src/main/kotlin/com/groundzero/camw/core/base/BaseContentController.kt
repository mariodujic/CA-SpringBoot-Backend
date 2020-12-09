package com.groundzero.camw.core.base

import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.data.NetworkModel
import com.groundzero.camw.core.network.NetworkResponse
import com.groundzero.camw.utils.NO_DATA_AVAILABLE
import com.groundzero.camw.utils.code
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.RequestBody

open class BaseContentController<T : NetworkModel>(
        private val baseContentRepository: BaseContentRepository<T>,
        private val baseContentValidator: BaseContentValidator
) {

    fun getItemsResponse(type: DataType): NetworkResponse {
        baseContentRepository.getItems(type)?.let {
            return if (baseContentValidator.hasItems(it)) {
                NetworkResponse.Success(code(HttpStatus.OK), "Success", it)
            } else {
                NetworkResponse.Error(code(HttpStatus.NOT_FOUND), NO_DATA_AVAILABLE)
            }
        }
        return NetworkResponse.Error(code(HttpStatus.NOT_FOUND), "Error")
    }

    open fun removeItemResponse(@RequestBody item: T, type: DataType): NetworkResponse {
        return if (!baseContentValidator.hasItemId(item.itemId)) {
            NetworkResponse.Error(code(HttpStatus.NOT_ACCEPTABLE), "Missing itemId")
        } else if (baseContentRepository.removeItem(item, type)) {
            val items = baseContentRepository.getItems(type)
            NetworkResponse.Success(code(HttpStatus.OK), "Success", items)
        } else {
            NetworkResponse.Error(code(HttpStatus.NOT_FOUND), "Error")
        }
    }

    open fun addItemResponse(item: T, type: DataType): NetworkResponse {
        return if (!baseContentValidator.hasItemId(item.itemId)) {
            NetworkResponse.Error(code(HttpStatus.NOT_ACCEPTABLE), "Missing itemId")
        } else if (baseContentRepository.addItem(item, type)) {
            val items = baseContentRepository.getItems(type)
            NetworkResponse.Success(code(HttpStatus.OK), "Success", items)
        } else NetworkResponse.Error(code(HttpStatus.NOT_FOUND), "Error")
    }
}