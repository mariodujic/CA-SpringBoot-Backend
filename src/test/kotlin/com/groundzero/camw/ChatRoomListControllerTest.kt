package com.groundzero.camw

import com.groundzero.camw.core.base.BaseContentValidator
import com.groundzero.camw.core.base.BaseContentValidatorImpl
import com.groundzero.camw.features.chat.chatroomlist.controller.ChatRoomListController
import com.groundzero.camw.features.chat.chatroomlist.data.ChatRoom
import com.groundzero.camw.features.chat.chatroomlist.data.ChatRoomDataType
import com.groundzero.camw.features.chat.chatroomlist.data.ChatRoomListRepository
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.`when`
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders


@ExtendWith(MockitoExtension::class)
class ChatRoomListControllerTest {

    @Mock
    private lateinit var contentRepository: ChatRoomListRepository

    private lateinit var mvc: MockMvc
    private lateinit var contentValidator: BaseContentValidator
    private lateinit var chatROomListController: ChatRoomListController

    @BeforeEach
    fun setUp() {
        contentValidator = BaseContentValidatorImpl()
        chatROomListController = ChatRoomListController(contentRepository, contentValidator)
        mvc = MockMvcBuilders.standaloneSetup(chatROomListController)
            .build()
    }

    @Test
    fun `en chat room should return correct data`() {
        `when`(contentRepository.getItems(ChatRoomDataType.English)).thenReturn(mutableListOf(MOCK_CHAT_ROOM_EN))
        assertTrue(getResponse("/chat-rooms/en").contains(MOCK_CHAT_ROOM_EN.itemId.toString()))
    }

    @Test
    fun `en staging chat room should return correct data`() {
        `when`(contentRepository.getItems(ChatRoomDataType.EnglishStaging)).thenReturn(
            mutableListOf(MOCK_CHAT_ROOM_EN_STAGING)
        )
        assertTrue(getResponse("/chat-rooms/en-staging").contains(MOCK_CHAT_ROOM_EN_STAGING.itemId.toString()))
    }

    @Test
    fun `hr chat room should return correct data`() {
        `when`(contentRepository.getItems(ChatRoomDataType.Croatian)).thenReturn(mutableListOf(MOCK_CHAT_ROOM_HR))
        assertTrue(getResponse("/chat-rooms/hr").contains(MOCK_CHAT_ROOM_HR.itemId.toString()))
    }

    @Test
    fun `hr staging chat room should return correct data`() {
        `when`(contentRepository.getItems(ChatRoomDataType.CroatianStaging)).thenReturn(
            mutableListOf(MOCK_CHAT_ROOM_HR_STAGING)
        )
        assertTrue(getResponse("/chat-rooms/hr-staging").contains(MOCK_CHAT_ROOM_HR_STAGING.itemId.toString()))
    }

    private fun getResponse(url: String) =
        mvc.perform(get(url).accept(MediaType.APPLICATION_JSON)).andReturn().response.contentAsString

    private companion object {
        val MOCK_CHAT_ROOM_EN = ChatRoom("asd42")
        val MOCK_CHAT_ROOM_EN_STAGING = ChatRoom("bj56")
        val MOCK_CHAT_ROOM_HR = ChatRoom("g56")
        val MOCK_CHAT_ROOM_HR_STAGING = ChatRoom("vbn45")
    }
}