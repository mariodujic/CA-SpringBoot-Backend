package com.groundzero.camw.core.security

import com.groundzero.camw.features.serverstatus.ServerStatusSocketConfigurer.Companion.SERVER_STATUS_END_POINT
import com.groundzero.camw.utils.INVALID_SECRET
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class SecretAuthenticationFilter : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {

        if (!allowedEndPoint(request) && !validSecret(request)) {
            throw SecurityException(INVALID_SECRET)
        }
        chain.doFilter(request, response)
    }

    private fun allowedEndPoint(request: HttpServletRequest) = request.servletPath == SERVER_STATUS_END_POINT
    private fun validSecret(request: HttpServletRequest) = AUTHENTICATION_SECRET == request.getHeader(AUTHENTICATION_KEY)

    private companion object {
        const val AUTHENTICATION_KEY = "CA-Auth"
        const val AUTHENTICATION_SECRET = "camw-application-data-ahfkk23lgp339"
    }
}