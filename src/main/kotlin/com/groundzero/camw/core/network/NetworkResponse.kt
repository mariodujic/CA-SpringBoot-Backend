package com.groundzero.camw.core.network

sealed class NetworkResponse {
    data class Success<out T>(val status: Int? = null, val message: String? = null, val data: T? = null) : NetworkResponse()
    data class Error(val status: Int, val message: String) : NetworkResponse()
}