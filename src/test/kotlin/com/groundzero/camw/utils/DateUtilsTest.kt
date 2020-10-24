package com.groundzero.camw.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.text.SimpleDateFormat
import java.util.*

class DateUtilsTest {

    @Test
    fun `should assert equals format for current date`() {
        val date = Date()
        val expectedValue = SimpleDateFormat(DATE_FORMAT).format(date)
        val actualValue = DateUtils.currentDate(date)
        assertEquals(expectedValue, actualValue)
    }

    private companion object {
        const val DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    }
}