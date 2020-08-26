package com.groundzero.camw.utils

fun Boolean.getJsonLog(message: String? = null) {
    println((if (this) JSON_WRITTEN_TRUE else JSON_WRITTEN_FALSE) + " $message")
}