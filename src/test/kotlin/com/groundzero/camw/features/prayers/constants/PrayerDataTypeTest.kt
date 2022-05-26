package com.groundzero.camw.features.prayers.constants

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PrayerDataTypeTest {

    @Test
    fun `should return English prayer path`() {
        val expectedPath = PRAYER_EN_COLLECTION
        val actualPath = PrayerDataType.English.path
        assertEquals(expectedPath, actualPath)
    }

    @Test
    fun `should return EnglishStaging prayer path`() {
        val expectedPath = PRAYER_EN_COLLECTION_STAGING
        val actualPath = PrayerDataType.EnglishStaging.path
        assertEquals(expectedPath, actualPath)
    }

    @Test
    fun `should return Croatian prayer path`() {
        val expectedPath = PRAYER_HR_COLLECTION
        val actualPath = PrayerDataType.Croatian.path
        assertEquals(expectedPath, actualPath)
    }

    @Test
    fun `should return CroatianStaging prayer path`() {
        val expectedPath = PRAYER_HR_COLLECTION_STAGING
        val actualPath = PrayerDataType.CroatianStaging.path
        assertEquals(expectedPath, actualPath)
    }

    @Test
    fun `should return Slovak prayer path`() {
        val expectedPath = PRAYER_SK_COLLECTION
        val actualPath = PrayerDataType.Slovak.path
        assertEquals(expectedPath, actualPath)
    }

    @Test
    fun `should return SlovakStaging prayer path`() {
        val expectedPath = PRAYER_SK_COLLECTION_STAGING
        val actualPath = PrayerDataType.SlovakStaging.path
        assertEquals(expectedPath, actualPath)
    }

    @Test
    fun `should return Spanish prayer path`() {
        val expectedPath = PRAYER_ES_COLLECTION
        val actualPath = PrayerDataType.Spanish.path
        assertEquals(expectedPath, actualPath)
    }

    @Test
    fun `should return SpanishStaging prayer path`() {
        val expectedPath = PRAYER_ES_COLLECTION_STAGING
        val actualPath = PrayerDataType.SpanishStaging.path
        assertEquals(expectedPath, actualPath)
    }
}