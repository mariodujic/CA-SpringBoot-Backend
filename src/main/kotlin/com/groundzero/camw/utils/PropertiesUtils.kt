package com.groundzero.camw.utils

import java.util.*

class PropertiesUtils {

    companion object {
        inline fun <reified T> getPropertyValue(propertyFile: String, key: String): String = run {
            val properties = Properties()
            properties.load(T::class.java.classLoader.getResourceAsStream(propertyFile))
            return properties.getProperty(key)
        }
    }
}