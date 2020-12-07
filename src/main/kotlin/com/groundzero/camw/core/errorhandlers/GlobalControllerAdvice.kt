package com.groundzero.camw.core.errorhandlers

import com.groundzero.camw.core.network.NetworkResponse
import com.groundzero.camw.utils.END_POINT_NOT_FOUND
import com.groundzero.camw.utils.INVALID_REQUEST
import com.groundzero.camw.utils.code
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException

@RestControllerAdvice
class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException::class)
    fun onNotFoundException(): NetworkResponse {
        return NetworkResponse.Error(code(HttpStatus.NOT_FOUND), END_POINT_NOT_FOUND)
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun onBadRequestException(): NetworkResponse {
        return NetworkResponse.Error(code(HttpStatus.BAD_REQUEST), INVALID_REQUEST)
    }
}