package com.groundzero.camw.features.messaging.mappers

import com.groundzero.camw.core.data.Mapper
import com.groundzero.camw.features.messaging.data.NotificationRequest
import com.groundzero.camw.features.messaging.data.UpdateNotificationResponse
import org.springframework.stereotype.Component

@Component
class MessageToUpdateNotificationMapper : Mapper<NotificationRequest, UpdateNotificationResponse> {

    override fun map(data: NotificationRequest): UpdateNotificationResponse = UpdateNotificationResponse(
            notificationType = 2,
            title = data.title,
            text = data.text,
            url = data.url,
            version = data.version
    )
}