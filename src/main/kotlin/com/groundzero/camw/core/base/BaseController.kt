package com.groundzero.camw.core.base

import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.network.NetworkResponse
import com.groundzero.camw.prayers.data.Prayer
import org.springframework.web.bind.annotation.RequestBody

open class BaseController<T>(private val baseRepository: BaseRepository<T>) {

    fun getItemsResponse(type: DataType): NetworkResponse {
        baseRepository.getItems(type)?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    fun removeItemResponse(@RequestBody item: T, type: DataType): NetworkResponse {
        baseRepository.removeItem(item, type)
        return NetworkResponse.Success<Prayer>(200, "Success", mutableListOf())
    }

    fun addItemResponse(item: T, type: DataType): NetworkResponse {
        baseRepository.addItem(item, type)
        return NetworkResponse.Success<Prayer>(200, "Success", mutableListOf())
    }
}