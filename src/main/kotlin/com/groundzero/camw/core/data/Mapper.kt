package com.groundzero.camw.core.data

interface Mapper<T, E> {
    fun map(data: T): E
}