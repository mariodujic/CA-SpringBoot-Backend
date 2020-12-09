package com.groundzero.camw.core.base

interface BaseContentValidator {
    fun hasItemId(itemId: String?): Boolean
    fun <T> hasItems(list: List<T>): Boolean
}