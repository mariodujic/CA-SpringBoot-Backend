package com.groundzero.camw.utils

import java.util.*

class PropertiesUtils {

    companion object {
        inline fun <reified T> getAuthenticationCredentials(key: String): String = run {
            val properties = Properties()
            properties.load(T::class.java.classLoader.getResourceAsStream("secret.properties"))
            return properties.getProperty(key)
        }
    }
}