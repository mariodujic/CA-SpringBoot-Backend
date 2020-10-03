package com.groundzero.camw.features.messaging.mappers

import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.features.messaging.data.NotificationRequest
import com.groundzero.camw.features.thoughts.data.Thought
import com.groundzero.camw.utils.DateUtils
import org.springframework.stereotype.Component

@Component
class MessageToThoughtDomainMapper : Mapper<NotificationRequest, Thought> {

    override fun map(data: NotificationRequest): Thought = Thought(
            itemId = data.itemId,
            author = data.author,
            date = DateUtils.currentDate(),
            image = data.image,
            text = data.text,
            title = data.title
    )
}