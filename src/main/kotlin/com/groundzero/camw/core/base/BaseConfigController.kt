package com.groundzero.camw.core.base

import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.network.NetworkResponse
import org.springframework.http.HttpStatus

open class BaseConfigController<T>(private val baseRepository: BaseConfigRepository<T>) {

    fun getItemsResponse(type: DataType): NetworkResponse {
        baseRepository.getConfig(type)?.let {
            return NetworkResponse.Success(HttpStatus.OK.value(), "Success", it)
        }
        return NetworkResponse.Error(HttpStatus.NOT_FOUND.value(), "Error")
    }

    fun addItemResponse(item: T, type: DataType): NetworkResponse {
        return if (baseRepository.addConfig(item, type)) {
            val item = baseRepository.getConfig(type)
            NetworkResponse.Success<T>(HttpStatus.OK.value(), "Success", item)
        } else {
            NetworkResponse.Error(HttpStatus.NOT_FOUND.value(), "Error")
        }
    }
}