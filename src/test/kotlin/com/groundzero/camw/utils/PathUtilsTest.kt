package com.groundzero.camw.utils

import com.groundzero.camw.features.prayers.constants.PrayerDataType
import com.groundzero.camw.features.quizzes.constants.QuizDataType
import com.groundzero.camw.features.saints.constants.SaintsDataType
import com.groundzero.camw.features.thoughts.constants.ThoughtDataType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PathUtilsTest {

    @Test
    fun `should assert equals storage path`() {
        val expectedValue = "src/main/resources/database/$COLLECTION_KEY.json"
        val actualValue = getJsonStoragePath(COLLECTION_KEY)
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `should assert true as classes are subclasses of PrayerDataType`(){
        assertTrue(PrayerDataType.Croatian.isSubclassOf(PrayerDataType::class))
        assertTrue(PrayerDataType.CroatianStaging.isSubclassOf(PrayerDataType::class))
        assertTrue(PrayerDataType.English.isSubclassOf(PrayerDataType::class))
        assertTrue(PrayerDataType.EnglishStaging.isSubclassOf(PrayerDataType::class))
    }

    @Test
    fun `should assert true as classes are subclasses of ThoughtDataType`(){
        assertTrue(ThoughtDataType.Croatian.isSubclassOf(ThoughtDataType::class))
        assertTrue(ThoughtDataType.CroatianStaging.isSubclassOf(ThoughtDataType::class))
        assertTrue(ThoughtDataType.English.isSubclassOf(ThoughtDataType::class))
        assertTrue(ThoughtDataType.EnglishStaging.isSubclassOf(ThoughtDataType::class))
    }

    @Test
    fun `should assert true as classes are subclasses of QuizDataType`(){
        assertTrue(QuizDataType.Croatian.isSubclassOf(QuizDataType::class))
        assertTrue(QuizDataType.CroatianStaging.isSubclassOf(QuizDataType::class))
        assertTrue(QuizDataType.English.isSubclassOf(QuizDataType::class))
        assertTrue(QuizDataType.EnglishStaging.isSubclassOf(QuizDataType::class))
    }

    @Test
    fun `should assert true as classes are subclasses of SaintsDataType`(){
        assertTrue(SaintsDataType.Croatian.isSubclassOf(SaintsDataType::class))
        assertTrue(SaintsDataType.CroatianStaging.isSubclassOf(SaintsDataType::class))
        assertTrue(SaintsDataType.English.isSubclassOf(SaintsDataType::class))
        assertTrue(SaintsDataType.EnglishStaging.isSubclassOf(SaintsDataType::class))
    }

    private companion object {
        const val COLLECTION_KEY = "a"
    }
}