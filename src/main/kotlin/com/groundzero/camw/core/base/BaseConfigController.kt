package com.groundzero.camw.core.base

import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.network.NetworkResponse

open class BaseConfigController<T>(private val baseRepository: BaseConfigRepository<T>) {

    fun getItemsResponse(type: DataType): NetworkResponse {
        baseRepository.getConfig(type)?.let {
            return NetworkResponse.Success(200, "Success", it)
        }
        return NetworkResponse.Error(404, "Error")
    }

    fun addItemResponse(item: T, type: DataType): NetworkResponse {
        return if (baseRepository.addConfig(item, type)) {
            NetworkResponse.Success<T>(200, "Success")
        } else {
            NetworkResponse.Error(404, "Error")
        }
    }
}