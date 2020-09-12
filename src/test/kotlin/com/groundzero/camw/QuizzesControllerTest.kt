package com.groundzero.camw

import com.groundzero.camw.core.base.BaseRepository
import com.groundzero.camw.quizzes.constants.QuizDataType
import com.groundzero.camw.quizzes.controller.QuizController
import com.groundzero.camw.quizzes.data.QuizCategory
import com.groundzero.camw.thoughts.constants.ThoughtDataType
import com.groundzero.camw.thoughts.data.Thought
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.`when`
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders


@ExtendWith(MockitoExtension::class)
class QuizzesControllerTest {

    private lateinit var mvc: MockMvc

    @Mock
    private lateinit var repository: BaseRepository<QuizCategory>

    @InjectMocks
    private lateinit var quizController: QuizController

    @BeforeEach
    fun setUp() {
        mvc = MockMvcBuilders.standaloneSetup(quizController).build()
    }

    @Test
    fun `en quizzes should return correct data`() {
        `when`(repository.getItems(QuizDataType.English)).thenReturn(mutableListOf(MOCK_QUIZ_CATEGORY_THOUGHT_EN))
        assertTrue(getResponse("/quizzes/en").contains(MOCK_QUIZ_CATEGORY_THOUGHT_EN.itemId.toString()))
    }

    @Test
    fun `en staging quizzes should return correct data`() {
        `when`(repository.getItems(QuizDataType.EnglishStaging)).thenReturn(mutableListOf(MOCK_QUIZ_CATEGORY_THOUGHT_EN_STAGING))
        assertTrue(getResponse("/quizzes/en-staging").contains(MOCK_QUIZ_CATEGORY_THOUGHT_EN_STAGING.itemId.toString()))
    }

    @Test
    fun `hr quizzes should return correct data`() {
        `when`(repository.getItems(QuizDataType.Croatian)).thenReturn(mutableListOf(MOCK_QUIZ_CATEGORY_THOUGHT_HR))
        assertTrue(getResponse("/quizzes/hr").contains(MOCK_QUIZ_CATEGORY_THOUGHT_HR.itemId.toString()))
    }

    @Test
    fun `hr staging quizzes should return correct data`() {
        `when`(repository.getItems(QuizDataType.CroatianStaging)).thenReturn(mutableListOf(MOCK_QUIZ_CATEGORY_THOUGHT_HR_STAGING))
        assertTrue(getResponse("/quizzes/hr-staging").contains(MOCK_QUIZ_CATEGORY_THOUGHT_HR_STAGING.itemId.toString()))
    }

    private fun getResponse(url: String) = mvc.perform(get(url).accept(MediaType.APPLICATION_JSON)).andReturn().response.contentAsString

    private companion object {
        val MOCK_QUIZ_CATEGORY_THOUGHT_EN = QuizCategory("asd42")
        val MOCK_QUIZ_CATEGORY_THOUGHT_EN_STAGING = QuizCategory("bj56")
        val MOCK_QUIZ_CATEGORY_THOUGHT_HR = QuizCategory("g56")
        val MOCK_QUIZ_CATEGORY_THOUGHT_HR_STAGING = QuizCategory("vbn45")
    }
}