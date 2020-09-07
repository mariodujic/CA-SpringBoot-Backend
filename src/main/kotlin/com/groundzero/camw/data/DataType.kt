package com.groundzero.camw.data

sealed class DataType(val path: String) {
    open class English(path: String) : DataType(path)
    open class EnglishStaging(path: String) : DataType(path)
    open class Croatian(path: String) : DataType(path)
    open class CroatianStaging(path: String) : DataType(path)
}