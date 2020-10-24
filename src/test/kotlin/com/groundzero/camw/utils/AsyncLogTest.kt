package com.groundzero.camw.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AsyncLogTest {

    @Test
    fun `should assert equals when boolean true`() {
        val expectedValue = "$JSON_WRITTEN_TRUE $MOCK_MESSAGE"
        val actualValue = true.getJsonLog(MOCK_MESSAGE)
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `should assert equals when boolean false`() {
        val expectedValue = "$JSON_WRITTEN_FALSE $MOCK_MESSAGE"
        val actualValue = false.getJsonLog(MOCK_MESSAGE)
        assertEquals(expectedValue, actualValue)
    }

    private companion object {
        const val MOCK_MESSAGE = "a"
    }
}