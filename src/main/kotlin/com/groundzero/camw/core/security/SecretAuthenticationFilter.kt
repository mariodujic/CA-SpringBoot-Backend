package com.groundzero.camw.core.security

import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class SecretAuthenticationFilter : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {

        val auth = request.getHeader(AUTHENTICATION_KEY)
        if (AUTHENTICATION_SECRET != auth) {
            throw SecurityException()
        }
        chain.doFilter(request, response)
    }

    companion object {
        private const val AUTHENTICATION_KEY = "CA-Auth"
        private const val AUTHENTICATION_SECRET = "camw-application-data-ahfkk23lgp339"
    }
}