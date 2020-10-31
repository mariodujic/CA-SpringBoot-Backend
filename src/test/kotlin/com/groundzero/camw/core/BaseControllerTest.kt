package com.groundzero.camw.core

import com.groundzero.camw.core.base.BaseController
import com.groundzero.camw.core.base.BaseRepository
import com.groundzero.camw.core.network.NetworkResponse
import com.groundzero.camw.features.information.constants.InformationBlockDataType
import com.groundzero.camw.features.information.data.InformationBlock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class BaseControllerTest {

    @Mock
    private lateinit var baseRepository: BaseRepository<InformationBlock>

    @InjectMocks
    private lateinit var sut: BaseController<InformationBlock>

    @Test
    fun `should invoke getItems once`() {
        sut.getItemsResponse(MOCK_DATA_TYPE)
        verify(baseRepository).getItems(MOCK_DATA_TYPE)
    }

    @Test
    fun `should invoke removeItem once`() {
        sut.removeItemResponse(MOCK_DATA, MOCK_DATA_TYPE)
        verify(baseRepository).removeItem(MOCK_DATA, MOCK_DATA_TYPE)
    }

    @Test
    fun `should invoke addItem once`() {
        sut.addItemResponse(MOCK_DATA, MOCK_DATA_TYPE)
        verify(baseRepository).addItem(MOCK_DATA, MOCK_DATA_TYPE)
    }

    @Test
    fun `should assert equals when getItems is success`() {
        `when`(baseRepository.getItems(MOCK_DATA_TYPE)).thenReturn(MOCK_DATA_LIST)
        val expectedValue = mockSuccessResponse(MOCK_DATA_LIST)
        val actualValue = sut.getItemsResponse(MOCK_DATA_TYPE)
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `should assert equals when getItems is null`() {
        `when`(baseRepository.getItems(MOCK_DATA_TYPE)).thenReturn(null)
        val expectedValue = mockErrorResponse()
        val actualValue = sut.getItemsResponse(MOCK_DATA_TYPE)
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `should assert equals when removeItem is true`() {
        `when`(baseRepository.removeItem(MOCK_DATA, MOCK_DATA_TYPE)).thenReturn(true)
        val expectedValue = mockSuccessResponse(mutableListOf())
        val actualValue = sut.removeItemResponse(MOCK_DATA, MOCK_DATA_TYPE)
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `should assert equals when removeItem is false`() {
        `when`(baseRepository.removeItem(MOCK_DATA, MOCK_DATA_TYPE)).thenReturn(false)
        val expectedValue = mockErrorResponse()
        val actualValue = sut.removeItemResponse(MOCK_DATA, MOCK_DATA_TYPE)
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `should assert equals when addItem is true`() {
        `when`(baseRepository.addItem(MOCK_DATA, MOCK_DATA_TYPE)).thenReturn(true)
        val expectedValue = mockSuccessResponse(mutableListOf())
        val actualValue = sut.addItemResponse(MOCK_DATA, MOCK_DATA_TYPE)
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `should assert equals when addItem is false`() {
        `when`(baseRepository.addItem(MOCK_DATA, MOCK_DATA_TYPE)).thenReturn(false)
        val expectedValue = mockErrorResponse()
        val actualValue = sut.addItemResponse(MOCK_DATA, MOCK_DATA_TYPE)
        assertEquals(expectedValue, actualValue)
    }

    companion object {
        val MOCK_DATA_TYPE = InformationBlockDataType.Croatian
        val MOCK_DATA = InformationBlock()
        fun mockSuccessResponse(data: List<InformationBlock>) = NetworkResponse.Success(200, "Success", data)
        val MOCK_DATA_LIST = listOf<InformationBlock>()
        fun mockErrorResponse() = NetworkResponse.Error(404, "Error")
    }
}