package com.groundzero.camw.core.security

import com.groundzero.camw.features.authentication.AuthenticationService
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class SecretAuthenticationFilter(private val authenticationService: AuthenticationService) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {

        if (!validSecret(request) || !validUser(request)) {
            throw SecurityException()
        }
        chain.doFilter(request, response)
    }

    private fun validSecret(request: HttpServletRequest) = AUTHENTICATION_SECRET == request.getHeader(AUTHENTICATION_KEY)

    fun validUser(request: HttpServletRequest): Boolean {
        val uidValue = request.getHeader(UID_KEY)
        return authenticationService.authenticateUser(uidValue)
    }

    companion object {
        private const val AUTHENTICATION_KEY = "CA-Auth"
        private const val AUTHENTICATION_SECRET = "camw-application-data-ahfkk23lgp339"
        private const val UID_KEY = "CA-Uid"
    }
}