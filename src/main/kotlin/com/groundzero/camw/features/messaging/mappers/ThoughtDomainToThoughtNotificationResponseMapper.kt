package com.groundzero.camw.features.messaging.mappers

import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.features.messaging.data.ThoughtNotificationResponse
import com.groundzero.camw.features.thoughts.data.Thought
import org.springframework.stereotype.Component

@Component
class ThoughtDomainToThoughtNotificationResponseMapper : Mapper<Thought, ThoughtNotificationResponse> {

    override fun map(data: Thought): ThoughtNotificationResponse =
            ThoughtNotificationResponse(
                    notificationType = 0,
                    author = data.author,
                    date = data.date,
                    image = data.image,
                    text = data.text,
                    title = data.title,
                    itemId = data.itemId
            )
}