package com.groundzero.camw.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
open class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    private lateinit var filter: SecretAuthenticationFilter

    override fun configure(http: HttpSecurity) {
        http
                .addFilterBefore(filter, BasicAuthenticationFilter::class.java)
                .antMatcher("**")
    }
}