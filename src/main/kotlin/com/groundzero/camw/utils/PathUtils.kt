package com.groundzero.camw.utils

import com.groundzero.camw.core.data.DataType
import kotlin.reflect.KClass

fun getJsonStoragePath(collectionKey: String) = "src/main/resources/database/$collectionKey.json"

fun DataType.isSubclassOf(kClass: KClass<*>) = kClass.nestedClasses.contains(this::class)
