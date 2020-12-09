package com.groundzero.camw.core.base

import org.springframework.stereotype.Service

@Service
class BaseContentValidatorImpl : BaseContentValidator {
    override fun hasItemId(itemId: String?): Boolean = !itemId.isNullOrBlank()
    override fun <T> hasItems(list: List<T>): Boolean = list.isNotEmpty()
}