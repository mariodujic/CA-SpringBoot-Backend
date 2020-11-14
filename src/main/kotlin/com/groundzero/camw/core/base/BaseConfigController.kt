package com.groundzero.camw.core.base

import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.network.NetworkResponse
import com.groundzero.camw.utils.code
import org.springframework.http.HttpStatus

open class BaseConfigController<T>(private val baseRepository: BaseConfigRepository<T>) {

    fun getItemsResponse(type: DataType): NetworkResponse {
        baseRepository.getConfig(type)?.let {
            return NetworkResponse.Success(code(HttpStatus.OK), "Success", it)
        }
        return NetworkResponse.Error(code(HttpStatus.NOT_FOUND), "Error")
    }

    fun addItemResponse(item: T, type: DataType): NetworkResponse {
        return if (baseRepository.addConfig(item, type)) {
            val item = baseRepository.getConfig(type)
            NetworkResponse.Success<T>(code(HttpStatus.OK), "Success", item)
        } else {
            NetworkResponse.Error(code(HttpStatus.NOT_FOUND), "Error")
        }
    }
}