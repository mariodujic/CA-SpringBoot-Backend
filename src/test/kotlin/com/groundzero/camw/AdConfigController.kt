package com.groundzero.camw

import com.fasterxml.jackson.databind.ObjectMapper
import com.groundzero.camw.core.base.BaseConfigRepository
import com.groundzero.camw.features.adconfig.constants.AdConfigDataType
import com.groundzero.camw.features.adconfig.controller.AdConfigController
import com.groundzero.camw.features.adconfig.data.AdConfig
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
class AdConfigControllerTest {

    private lateinit var mvc: MockMvc
    private lateinit var objectMapper: ObjectMapper

    @Mock
    private lateinit var adConfigRepository: BaseConfigRepository<AdConfig>

    @InjectMocks
    private lateinit var adConfigController: AdConfigController

    @BeforeEach
    fun setUp() {
        objectMapper = ObjectMapper()
        mvc = MockMvcBuilders.standaloneSetup(adConfigController).build()
    }

    @Test
    fun `en ad config should return correct data`() {
        `when`(adConfigRepository.getConfig(AdConfigDataType.English)).thenReturn(MOCK_AD_CONFIG_EN)
        assertTrue(getResponse("/ad-config/en").contains(MOCK_AD_CONFIG_EN.showExitApplicationInterstitial.toString()))

    }

    @Test
    fun `en staging ad config should return correct data`() {
        `when`(adConfigRepository.getConfig(AdConfigDataType.EnglishStaging)).thenReturn(MOCK_AD_CONFIG_EN_STAGING)
        assertTrue(getResponse("/ad-config/en-staging").contains(MOCK_AD_CONFIG_EN_STAGING.showBookmarksInterstitial.toString()))
    }

    @Test
    fun `hr ad config should return correct data`() {
        `when`(adConfigRepository.getConfig(AdConfigDataType.Croatian)).thenReturn(MOCK_AD_CONFIG_HR_STAGING)
        assertTrue(getResponse("/ad-config/hr").contains(MOCK_AD_CONFIG_HR.showQuizFinishInterstitial.toString()))
    }

    @Test
    fun `hr staging ad config should return correct data`() {
        `when`(adConfigRepository.getConfig(AdConfigDataType.CroatianStaging)).thenReturn(MOCK_AD_CONFIG_HR_STAGING)
        assertTrue(getResponse("/ad-config/hr-staging").contains(MOCK_AD_CONFIG_HR_STAGING.showDrawerSupportByInterstitialAdButton.toString()))
    }

    private fun getResponse(url: String) = mvc.perform(get(url).accept(MediaType.APPLICATION_JSON)).andReturn().response.contentAsString

    private companion object {
        val MOCK_AD_CONFIG_EN = AdConfig(showExitApplicationInterstitial = true)
        val MOCK_AD_CONFIG_EN_STAGING = AdConfig(showBookmarksInterstitial = true)
        val MOCK_AD_CONFIG_HR = AdConfig(showQuizFinishInterstitial = true)
        val MOCK_AD_CONFIG_HR_STAGING = AdConfig(showDrawerSupportByInterstitialAdButton = true)
    }
}