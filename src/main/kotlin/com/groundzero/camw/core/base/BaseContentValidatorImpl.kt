package com.groundzero.camw.core.base

import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
class BaseContentValidatorImpl : BaseContentValidator {
    override fun hasItemId(itemId: String?): Boolean = !itemId.isNullOrBlank()
}