package com.groundzero.camw.core.security

import com.groundzero.camw.core.network.NetworkResponse
import com.groundzero.camw.core.network.WriteHttpServletResponse
import com.groundzero.camw.features.chat.configurer.ChatRoomWebSocketConfigurer.Companion.CHAT_ROOM_END_POINT
import com.groundzero.camw.features.serverstatus.ServerStatusSocketConfigurer.Companion.SERVER_STATUS_END_POINT
import com.groundzero.camw.utils.INVALID_SECRET
import com.groundzero.camw.utils.code
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class SecretAuthenticationFilter(
    private val writeResponse: WriteHttpServletResponse
) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        try {
            if (!allowedEndPoint(request) && !validSecret(request)) {
                throw SecurityException(INVALID_SECRET)
            }
            chain.doFilter(request, response)
        } catch (e: SecurityException) {
            val errorResponse = NetworkResponse.Error(code(HttpStatus.UNAUTHORIZED), INVALID_SECRET)
            writeResponse.run { response(errorResponse) }
        }
    }

    private fun allowedEndPoint(request: HttpServletRequest) =
        request.servletPath == SERVER_STATUS_END_POINT || request.servletPath.contains(CHAT_ROOM_END_POINT)

    private fun validSecret(request: HttpServletRequest) =
        AUTHENTICATION_SECRET == request.getHeader(AUTHENTICATION_KEY)

    private companion object {
        const val AUTHENTICATION_KEY = "CA-Auth"
        const val AUTHENTICATION_SECRET = "camw-application-data-ahfkk23lgp339"
    }
}