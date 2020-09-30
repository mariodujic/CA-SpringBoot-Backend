package com.groundzero.camw.features.messaging.mappers

import com.groundzero.camw.core.data.NullableMapper
import com.groundzero.camw.features.messaging.data.NotificationRequest
import com.groundzero.camw.features.messaging.data.MessageType
import org.springframework.stereotype.Component

@Component
class MessageToTypeMapper : NullableMapper<NotificationRequest, MessageType> {
    override fun map(data: NotificationRequest): MessageType? = MessageType.getEnum(data.messageType)
}