package com.groundzero.camw.security

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
class SecurityConfig(private val filter: SecretAuthenticationFilter) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
                .addFilterBefore(filter, BasicAuthenticationFilter::class.java)
                .antMatcher("**")
                .csrf().disable()
    }
}