package com.groundzero.camw.messaging.data

enum class MessageType(private val code: Int) {
    THOUGHT(0),
    INFORMATION(1);

    companion object {
        fun getEnum(value: Int): MessageType? = values().find { it.code == value }
    }
}