package com.groundzero.camw.core

import com.groundzero.camw.core.network.NetworkResponse
import com.groundzero.camw.core.network.WriteHttpServletResponse
import com.groundzero.camw.core.security.SecretAuthenticationFilter
import com.groundzero.camw.features.chat.chatroom.configurer.ChatRoomWebSocketConfigurer
import com.groundzero.camw.features.serverstatus.ServerStatusSocketConfigurer
import com.groundzero.camw.utils.INVALID_SECRET
import com.groundzero.camw.utils.code
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.HttpStatus
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ExtendWith(MockitoExtension::class)
class SecretAuthenticationFilterTest {

    @Mock
    private lateinit var writeResponse: WriteHttpServletResponse

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
        `when`(httpServletRequest.servletPath).thenReturn("")
        sut.doFilter(httpServletRequest, httpServletResponse, filterChain)
        verify(filterChain).doFilter(httpServletRequest, httpServletResponse)
    }

    @Test
    fun `should invoke filterChain doFilter function once if servlet path is server status websocket endpoint`() {
        `when`(httpServletRequest.servletPath).thenReturn(ServerStatusSocketConfigurer.SERVER_STATUS_END_POINT)
        sut.doFilter(httpServletRequest, httpServletResponse, filterChain)
        verify(filterChain).doFilter(httpServletRequest, httpServletResponse)
    }

    @Test
    fun `should invoke filterChain doFilter function once if servlet path is chat room websocket endpoint`() {
        `when`(httpServletRequest.servletPath).thenReturn(ChatRoomWebSocketConfigurer.CHAT_ROOM_END_POINT)
        sut.doFilter(httpServletRequest, httpServletResponse, filterChain)
        verify(filterChain).doFilter(httpServletRequest, httpServletResponse)
    }

    @Test()
    fun `should invoke writeResponse once with network response error when secret is invalid`() {
        `when`(httpServletRequest.getHeader(AUTHENTICATION_KEY)).thenReturn(INVALID_AUTHENTICATION_SECRET)
        `when`(httpServletRequest.servletPath).thenReturn("")
        sut.doFilter(httpServletRequest, httpServletResponse, filterChain)
        val expectedResponse = NetworkResponse.Error(code(HttpStatus.UNAUTHORIZED), INVALID_SECRET)
        verify(writeResponse).run { httpServletResponse(expectedResponse) }
    }

    private companion object {
        const val AUTHENTICATION_KEY = "CA-Auth"
        const val VALID_AUTHENTICATION_SECRET = "camw-application-data-ahfkk23lgp339"
        const val INVALID_AUTHENTICATION_SECRET = "a"
    }
}