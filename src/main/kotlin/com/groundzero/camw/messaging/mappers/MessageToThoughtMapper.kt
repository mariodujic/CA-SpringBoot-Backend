package com.groundzero.camw.messaging.mappers

import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.messaging.data.NotificationMessage
import com.groundzero.camw.thoughts.data.Thought
import com.groundzero.camw.utils.DateUtils
import org.springframework.stereotype.Component

@Component
class MessageToThoughtMapper : Mapper<NotificationMessage, Thought> {

    override fun map(data: NotificationMessage): Thought = Thought(
            itemId = data.id,
            author = data.author,
            date = DateUtils.currentDate(),
            image = data.image,
            text = data.text,
            title = data.title
    )
}