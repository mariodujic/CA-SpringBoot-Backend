package com.groundzero.camw.core

import com.groundzero.camw.core.base.BaseConfigController
import com.groundzero.camw.core.base.BaseConfigRepository
import com.groundzero.camw.core.network.NetworkResponse
import com.groundzero.camw.features.adconfig.data.AdConfig
import com.groundzero.camw.utils.code
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus

@ExtendWith(MockitoExtension::class)
class BaseConfigControllerTest {

    @Mock
    private lateinit var baseConfigRepository: BaseConfigRepository<AdConfig>

    @InjectMocks
    private lateinit var sut: BaseConfigController<AdConfig>

    @Test
    fun `should invoke getItems once`() {
        sut.getItemsResponse(MOCK_DATA_TYPE)
        verify(baseConfigRepository).getConfig(MOCK_DATA_TYPE)
    }

    @Test
    fun `should invoke addItem once`() {
        sut.addItemResponse(MOCK_DATA, MOCK_DATA_TYPE)
        verify(baseConfigRepository).addConfig(MOCK_DATA, MOCK_DATA_TYPE)
    }

    @Test
    fun `should assert equals when getConfig is success`() {
        `when`(baseConfigRepository.getConfig(MOCK_DATA_TYPE)).thenReturn(MOCK_DATA)
        val expectedValue = mockSuccessResponse(MOCK_DATA)
        val actualValue = sut.getItemsResponse(MOCK_DATA_TYPE)
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `should assert equals when getConfig is null`() {
        `when`(baseConfigRepository.getConfig(MOCK_DATA_TYPE)).thenReturn(null)
        val expectedValue = mockErrorResponse()
        val actualValue = sut.getItemsResponse(MOCK_DATA_TYPE)
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `should assert equals when addConfig is true`() {
        `when`(baseConfigRepository.addConfig(MOCK_DATA, MOCK_DATA_TYPE)).thenReturn(true)
        `when`(baseConfigRepository.getConfig(MOCK_DATA_TYPE)).thenReturn(MOCK_DATA)
        val expectedValue = mockSuccessResponse(MOCK_DATA)
        val actualValue = sut.addItemResponse(MOCK_DATA, MOCK_DATA_TYPE)
        assertEquals(expectedValue, actualValue)
    }

    @Test
    fun `should assert equals when addConfig is false`() {
        `when`(baseConfigRepository.addConfig(MOCK_DATA, MOCK_DATA_TYPE)).thenReturn(false)
        val expectedValue = mockErrorResponse()
        val actualValue = sut.addItemResponse(MOCK_DATA, MOCK_DATA_TYPE)
        assertEquals(expectedValue, actualValue)
    }

    companion object {
        val MOCK_DATA_TYPE = AdConfigDataType.Croatian
        val MOCK_DATA = AdConfig()
        fun mockSuccessResponse(data: AdConfig) = NetworkResponse.Success(code(HttpStatus.OK), "Success", data)
        fun mockErrorResponse() = NetworkResponse.Error(code(HttpStatus.NOT_FOUND), "Error")
    }
}