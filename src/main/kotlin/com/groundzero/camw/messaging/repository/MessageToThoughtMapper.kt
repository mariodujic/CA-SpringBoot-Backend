package com.groundzero.camw.messaging.repository

import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.messaging.data.Message
import com.groundzero.camw.thoughts.data.Thought
import java.util.*

class MessageToThoughtMapper : Mapper<Message, Thought> {

    override fun map(data: Message): Thought = Thought(
            itemId = data.id,
            author = data.author,
            date = Date().toString(),
            image = data.image,
            text = data.text,
            title = data.title
    )
}