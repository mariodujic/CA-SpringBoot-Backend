package com.groundzero.camw.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {

    fun currentDate(): String = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").format(Date())
}