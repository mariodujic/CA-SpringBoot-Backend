package com.groundzero.camw.data

import com.groundzero.camw.prayers.constants.PRAYERS_ENGLISH_COLLECTION
import com.groundzero.camw.prayers.data.Prayer
import com.groundzero.camw.quizzes.constants.QUIZZES_ENGLISH_COLLECTION
import com.groundzero.camw.quizzes.data.QuizCategory
import com.groundzero.camw.thoughts.constants.THOUGHTS_ENGLISH_COLLECTION
import com.groundzero.camw.thoughts.data.Thought
import com.groundzero.camw.utils.JsonUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class WriteJsonService {

    @Autowired
    private lateinit var readNetwork: ReadNetworkService

    @Autowired
    private lateinit var jsonUtils: JsonUtils

    fun writeJson() {
      /*  readNetwork.readDatabase<Prayer>()?.let {
            jsonUtils.writeJson(getDatabaseJsonPath(PRAYERS_ENGLISH_COLLECTION), it)
            println("Json prayers written successfully")
        }

        readNetwork.readDatabase<Thought>()?.let {
            jsonUtils.writeJson(getDatabaseJsonPath(THOUGHTS_ENGLISH_COLLECTION), it)
            println("Json thoughts written successfully")
        }*/

        readNetwork.readDatabase<QuizCategory>()?.let {
            jsonUtils.writeJson(getDatabaseJsonPath(QUIZZES_ENGLISH_COLLECTION), it)
            println("Json quizzes written successfully")
        }
    }

    private fun getDatabaseJsonPath(collectionKey: String) = "src/main/resources/database/$collectionKey.json"
}