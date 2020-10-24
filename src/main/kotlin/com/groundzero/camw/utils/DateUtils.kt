package com.groundzero.camw.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    fun currentDate(date: Date): String = SimpleDateFormat(DATE_FORMAT).format(date)

    private const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
}