package com.groundzero.camw.core

import com.groundzero.camw.core.security.SecretAuthenticationFilter
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ExtendWith(MockitoExtension::class)
class SecretAuthenticationFilterTest {

    @Mock
    private lateinit var httpServletRequest: HttpServletRequest

    @Mock
    private lateinit var httpServletResponse: HttpServletResponse

    @Mock
    private lateinit var filterChain: FilterChain

    @InjectMocks
    private lateinit var sut: SecretAuthenticationFilter

    @Test
    fun `should invoke filterChain doFilter function once if secret is valid`() {
        `when`(httpServletRequest.getHeader(AUTHENTICATION_KEY)).thenReturn(VALID_AUTHENTICATION_SECRET)
        sut.doFilter(httpServletRequest, httpServletResponse, filterChain)
        verify(filterChain).doFilter(httpServletRequest, httpServletResponse)
    }

    @Test()
    fun `should throw SecurityException if secret is invalid`() {
        assertThrows<SecurityException> {
            `when`(httpServletRequest.getHeader(AUTHENTICATION_KEY)).thenReturn(INVALID_AUTHENTICATION_SECRET)
            sut.doFilter(httpServletRequest, httpServletResponse, filterChain)
        }
    }

    private companion object {
        const val AUTHENTICATION_KEY = "CA-Auth"
        const val VALID_AUTHENTICATION_SECRET = "camw-application-data-ahfkk23lgp339"
        const val INVALID_AUTHENTICATION_SECRET = "a"
    }
}