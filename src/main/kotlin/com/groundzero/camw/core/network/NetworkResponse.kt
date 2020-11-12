package com.groundzero.camw.core.network

sealed class NetworkResponse {
    data class SuccessList<out T>(val status: Int, val message: String, val data: List<T>) : NetworkResponse()
    data class Success<out T>(val status: Int, val message: String, val data: T? = null) : NetworkResponse()
    data class Error(val status: Int, val message: String) : NetworkResponse()
}