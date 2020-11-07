package com.groundzero.camw.features.serverstatus

import org.springframework.context.annotation.Configuration
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker
import org.springframework.web.socket.config.annotation.StompEndpointRegistry
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer


@Configuration
@EnableWebSocketMessageBroker
class ServerStatusSocketConfigurer : WebSocketMessageBrokerConfigurer {

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        registry.addEndpoint(SERVER_STATUS_END_POINT).setAllowedOrigins("*")
    }

    companion object {
        const val SERVER_STATUS_END_POINT = "/server-status"
    }
}