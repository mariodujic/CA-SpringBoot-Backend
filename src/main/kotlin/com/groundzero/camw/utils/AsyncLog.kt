package com.groundzero.camw.utils

fun Boolean.getJsonLog(message: String? = null) =
        (if (this) JSON_WRITTEN_TRUE else JSON_WRITTEN_FALSE) + " $message"