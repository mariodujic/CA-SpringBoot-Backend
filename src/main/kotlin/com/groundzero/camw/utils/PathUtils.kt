package com.groundzero.camw.utils

import com.groundzero.camw.data.DataType
import kotlin.reflect.KClass

fun getJsonStoragePath(collectionKey: String) = "src/main/resources/database/$collectionKey.json"

fun DataType.isParentClass(kClass: KClass<*>) = kClass.nestedClasses.contains(this::class)
