package com.groundzero.camw.quizzes.data

import com.groundzero.camw.core.base.BaseRepository
import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.data.ItemMapper
import com.groundzero.camw.quizzes.constants.QuizDataType
import com.groundzero.camw.core.service.ReadJsonService
import com.groundzero.camw.core.service.WriteJsonService
import com.groundzero.camw.utils.isParentClass
import org.springframework.stereotype.Component

@Component
class QuizRepository(private val readJson: ReadJsonService, private val writeJson: WriteJsonService, private val mapper: ItemMapper<QuizCategory>) : BaseRepository<QuizCategory> {

    override fun getItems(dataType: DataType): List<QuizCategory>? =
            validateDataPathAndStartAction(dataType, readJson.read(dataType.path))

    override fun addItem(quizCategory: QuizCategory, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.write(dataType.path, mapper.addItem(quizCategory, getItems(dataType))))

    override fun removeItem(quizCategory: QuizCategory, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.write(dataType.path, mapper.removeItem(quizCategory, getItems(dataType))))

    private fun <T> validateDataPathAndStartAction(dataType: DataType, action: T): T = if (dataType.isParentClass(QuizDataType::class)) {
        action
    } else throw IllegalArgumentException()
}