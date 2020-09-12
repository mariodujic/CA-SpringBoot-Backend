package com.groundzero.camw

import com.groundzero.camw.core.base.BaseRepository
import com.groundzero.camw.thoughts.constants.ThoughtDataType
import com.groundzero.camw.thoughts.controller.ThoughtsController
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
class ThoughtsControllerTest {

    private lateinit var mvc: MockMvc

    @Mock
    private lateinit var repository: BaseRepository<Thought>

    @InjectMocks
    private lateinit var thoughtsController: ThoughtsController

    @BeforeEach
    fun setUp() {
        mvc = MockMvcBuilders.standaloneSetup(thoughtsController)
                .build()
    }

    @Test
    fun `en thoughts should return correct data`() {
        `when`(repository.getItems(ThoughtDataType.English)).thenReturn(mutableListOf(MOCK_THOUGHT_EN))
        assertTrue(getResponse("/thoughts/en").contains(MOCK_THOUGHT_EN.itemId.toString()))
    }

    @Test
    fun `en staging thoughts should return correct data`() {
        `when`(repository.getItems(ThoughtDataType.EnglishStaging)).thenReturn(mutableListOf(MOCK_THOUGHT_EN_STAGING))
        assertTrue(getResponse("/thoughts/en-staging").contains(MOCK_THOUGHT_EN_STAGING.itemId.toString()))
    }

    @Test
    fun `hr thoughts should return correct data`() {
        `when`(repository.getItems(ThoughtDataType.Croatian)).thenReturn(mutableListOf(MOCK_THOUGHT_HR))
        assertTrue(getResponse("/thoughts/hr").contains(MOCK_THOUGHT_HR.itemId.toString()))
    }

    @Test
    fun `hr staging thoughts should return correct data`() {
        `when`(repository.getItems(ThoughtDataType.CroatianStaging)).thenReturn(mutableListOf(MOCK_THOUGHT_HR_STAGING))
        assertTrue(getResponse("/thoughts/hr-staging").contains(MOCK_THOUGHT_HR_STAGING.itemId.toString()))
    }

    private fun getResponse(url: String) = mvc.perform(get(url).accept(MediaType.APPLICATION_JSON)).andReturn().response.contentAsString

    private companion object {
        val MOCK_THOUGHT_EN = Thought("asd42")
        val MOCK_THOUGHT_EN_STAGING = Thought("bj56")
        val MOCK_THOUGHT_HR = Thought("g56")
        val MOCK_THOUGHT_HR_STAGING = Thought("vbn45")
    }
}