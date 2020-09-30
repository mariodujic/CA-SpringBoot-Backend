package com.groundzero.camw.messaging.mappers

import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.messaging.data.ThoughtNotification
import com.groundzero.camw.thoughts.data.Thought
import org.springframework.stereotype.Component

@Component
class ThoughtToNotificationMapper : Mapper<Thought, ThoughtNotification> {

    override fun map(data: Thought): ThoughtNotification =
            ThoughtNotification(
                    notificationType = 0,
                    author = data.author,
                    date = data.date,
                    image = data.image,
                    text = data.text,
                    title = data.title,
                    itemId = data.itemId
            )
}