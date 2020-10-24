package com.groundzero.camw.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SerializationUtilsTest {

    private lateinit var sut: SerializationUtils

    @BeforeEach
    fun setUp() {
        sut = SerializationUtils()
    }

    @Test
    fun `should assert equals as data class is mapped`() {
        val expectedValue = mapOf(
                "itemA" to "a",
                "itemB" to "b"
        )
        val actualValue = MOCK_DATA_CLASS.asMap()
        assertEquals(expectedValue, actualValue)
    }

    private companion object {
        val MOCK_DATA_CLASS = TestData("a", "b")
    }

    data class TestData(val itemA: String, val itemB: String)
}