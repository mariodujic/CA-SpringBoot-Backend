package com.groundzero.camw.core.data

interface NullableMapper<T, E> {
    fun map(data: T): E?
}