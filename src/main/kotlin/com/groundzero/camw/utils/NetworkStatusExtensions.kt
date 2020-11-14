package com.groundzero.camw.utils

import org.springframework.http.HttpStatus

val code: HttpStatus.() -> Int = { value() }