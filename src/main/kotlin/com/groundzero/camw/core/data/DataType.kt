package com.groundzero.camw.core.data

sealed class DataType(val path: String) {
    open class English(path: String) : DataType(path)
    open class EnglishStaging(path: String) : DataType(path)
    open class Croatian(path: String) : DataType(path)
    open class CroatianStaging(path: String) : DataType(path)
    open class Slovak(path: String) : DataType(path)
    open class SlovakStaging(path: String) : DataType(path)
}