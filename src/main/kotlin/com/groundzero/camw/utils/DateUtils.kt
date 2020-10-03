package com.groundzero.camw.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    fun currentDate(): String = SimpleDateFormat(DATE_FORMAT).format(Date())

    private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
}