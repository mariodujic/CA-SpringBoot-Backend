package com.groundzero.camw.security

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class SecretAuthenticationFilter(
        @Value("\${data.auth.key}") private val dataKey: String,
        @Value("\${data.auth.secret}") private val dataSecret: String
) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {

        val auth = request.getHeader(dataKey)
        if (dataSecret != auth) {
            throw SecurityException()
        }
        chain.doFilter(request, response)
    }
}