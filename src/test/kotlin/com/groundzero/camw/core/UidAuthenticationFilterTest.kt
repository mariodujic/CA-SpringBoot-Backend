package com.groundzero.camw.core

import com.groundzero.camw.core.network.NetworkResponse
import com.groundzero.camw.core.network.WriteHttpServletResponse
import com.groundzero.camw.core.security.UidAuthenticationFilter
import com.groundzero.camw.core.security.UidAuthenticationFilter.Companion.UID_KEY
import com.groundzero.camw.core.security.UidAuthenticationFilter.Companion.USER_REPORT_PATH
import com.groundzero.camw.features.authentication.AuthenticationService
import com.groundzero.camw.utils.INVALID_UID
import com.groundzero.camw.utils.code
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ExtendWith(MockitoExtension::class)
class UidAuthenticationFilterTest {

    @Mock
    private lateinit var authenticationService: AuthenticationService

    @Mock
    private lateinit var writeResponse: WriteHttpServletResponse

    @Mock
    private lateinit var httpServletRequest: HttpServletRequest

    @Mock
    private lateinit var httpServletResponse: HttpServletResponse

    @Mock
    private lateinit var filterChain: FilterChain

    @InjectMocks
    private lateinit var sut: UidAuthenticationFilter

    @Test
    fun `should invoke filterChain doFilter function once if user id is valid`() {
        `when`(httpServletRequest.getHeader(UID_KEY)).thenReturn(MOCK_USER_ID)
        `when`(authenticationService.authenticateUser(MOCK_USER_ID)).thenReturn(true)
        sut.doFilter(httpServletRequest, httpServletResponse, filterChain)
        verify(filterChain).doFilter(httpServletRequest, httpServletResponse)
    }

    @Test
    fun `should invoke filterChain doFilter function once if user id is invalid and method is GET`() {
        `when`(httpServletRequest.getHeader(UID_KEY)).thenReturn(MOCK_USER_ID)
        `when`(httpServletRequest.method).thenReturn(HttpMethod.GET.name)
        `when`(authenticationService.authenticateUser(MOCK_USER_ID)).thenReturn(false)
        sut.doFilter(httpServletRequest, httpServletResponse, filterChain)
        verify(filterChain).doFilter(httpServletRequest, httpServletResponse)
    }

    @Test
    fun `should invoke filterChain doFilter if user id is invalid and method is POST and path user-report`() {
        `when`(httpServletRequest.getHeader(UID_KEY)).thenReturn(MOCK_USER_ID)
        `when`(authenticationService.authenticateUser(MOCK_USER_ID)).thenReturn(false)
        `when`(httpServletRequest.method).thenReturn(HttpMethod.POST.name)
        `when`(httpServletRequest.servletPath).thenReturn(USER_REPORT_PATH)
        sut.doFilter(httpServletRequest, httpServletResponse, filterChain)
        verify(filterChain).doFilter(httpServletRequest, httpServletResponse)
    }

    @Test
    fun `should not invoke filterChain doFilter if user id is invalid and method is POST and path is not user-report`() {
        `when`(httpServletRequest.getHeader(UID_KEY)).thenReturn(MOCK_USER_ID)
        `when`(authenticationService.authenticateUser(MOCK_USER_ID)).thenReturn(false)
        `when`(httpServletRequest.method).thenReturn(HttpMethod.POST.name)
        `when`(httpServletRequest.servletPath).thenReturn(MOCK_SERVLET_PATH)
        sut.doFilter(httpServletRequest, httpServletResponse, filterChain)
        verify(filterChain, times(0)).doFilter(httpServletRequest, httpServletResponse)
    }

    @Test
    fun `should invoke writeResponse once if user id is invalid and method is POST and path is not user-report`() {
        `when`(httpServletRequest.getHeader(UID_KEY)).thenReturn(MOCK_USER_ID)
        `when`(authenticationService.authenticateUser(MOCK_USER_ID)).thenReturn(false)
        `when`(httpServletRequest.method).thenReturn(HttpMethod.POST.name)
        `when`(httpServletRequest.servletPath).thenReturn(MOCK_SERVLET_PATH)
        sut.doFilter(httpServletRequest, httpServletResponse, filterChain)
        val expectedResponse = NetworkResponse.Error(code(HttpStatus.UNAUTHORIZED), INVALID_UID)
        verify(writeResponse).run { httpServletResponse(expectedResponse) }
    }

    private companion object {
        const val MOCK_USER_ID = "a"
        const val MOCK_SERVLET_PATH = "/ab"
    }
}