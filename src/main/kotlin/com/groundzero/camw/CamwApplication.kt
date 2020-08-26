package com.groundzero.camw

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CamwApplication

fun main(args: Array<String>) {
    runApplication<CamwApplication>(*args)
}
