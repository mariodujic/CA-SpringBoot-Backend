package com.groundzero.camw.core.security

import com.groundzero.camw.features.authentication.AuthenticationService
import com.groundzero.camw.utils.INVALID_UID
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class UidAuthenticationFilter(private val authenticationService: AuthenticationService) : OncePerRequestFilter() {

    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {

        if (!validUser(request) && !getRequest(request.method) && !postUserReportRequest(request)) {
            throw SecurityException(INVALID_UID)
        }
        chain.doFilter(request, response)
    }

    private fun validUser(request: HttpServletRequest): Boolean {
        val uidValue = request.getHeader(UID_KEY)
        return authenticationService.authenticateUser(uidValue)
    }

    private fun getRequest(requestMethod: String) = requestMethod == "GET"
    private fun postUserReportRequest(request: HttpServletRequest) =
            request.method == "POST" && request.servletPath.contains(USER_REPORT_PATH)

    companion object {
        private const val UID_KEY = "CA-Uid"
        private const val USER_REPORT_PATH = "/user-report"
    }
}