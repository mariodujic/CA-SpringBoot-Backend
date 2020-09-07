package com.groundzero.camw.quizzes.data

import com.groundzero.camw.data.DataType
import com.groundzero.camw.data.ItemMapper
import com.groundzero.camw.data.ReadJsonService
import com.groundzero.camw.data.WriteJsonService
import com.groundzero.camw.quizzes.constants.QuizDataType
import com.groundzero.camw.utils.isParentClass
import org.springframework.stereotype.Component

@Component
class QuizRepository(private val readJson: ReadJsonService, private val writeJson: WriteJsonService, private val mapper: ItemMapper<QuizCategory>) {

    fun getQuizCategories(dataType: DataType): List<QuizCategory>? =
            validateDataPathAndStartAction(dataType, readJson.read(dataType.path))

    fun addQuizCategory(quizCategory: QuizCategory, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.write(dataType.path, mapper.addItem(quizCategory, getQuizCategories(dataType))))

    private fun <T> validateDataPathAndStartAction(dataType: DataType, action: T): T = if (dataType.isParentClass(QuizDataType::class)) {
        action
    } else throw IllegalArgumentException()
}