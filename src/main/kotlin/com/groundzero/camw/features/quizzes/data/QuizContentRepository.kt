package com.groundzero.camw.features.quizzes.data

import com.groundzero.camw.core.base.BaseContentRepository
import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.data.ItemMapper
import com.groundzero.camw.features.quizzes.constants.QuizDataType
import com.groundzero.camw.core.service.ReadJsonService
import com.groundzero.camw.core.service.WriteJsonService
import com.groundzero.camw.utils.isSubclassOf
import org.springframework.stereotype.Component

@Component
class QuizContentRepository(private val readJson: ReadJsonService, private val writeJson: WriteJsonService, private val mapper: ItemMapper<QuizCategory>) : BaseContentRepository<QuizCategory> {

    override fun getItems(dataType: DataType): List<QuizCategory>? =
            validateDataPathAndStartAction(dataType, readJson.readList(dataType.path))

    override fun addItem(quizCategory: QuizCategory, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.writeList(dataType.path, mapper.addItem(quizCategory, getItems(dataType))))

    override fun removeItem(quizCategory: QuizCategory, dataType: DataType) =
            validateDataPathAndStartAction(dataType, writeJson.writeList(dataType.path, mapper.removeItem(quizCategory, getItems(dataType))))

    private fun <T> validateDataPathAndStartAction(dataType: DataType, action: T): T = if (dataType.isSubclassOf(QuizDataType::class)) {
        action
    } else throw IllegalArgumentException()
}