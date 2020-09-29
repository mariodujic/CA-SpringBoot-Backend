package com.groundzero.camw.messaging.mappers

import com.groundzero.camw.core.data.NullableMapper
import com.groundzero.camw.messaging.data.NotificationMessage
import com.groundzero.camw.messaging.data.MessageType
import org.springframework.stereotype.Component

@Component
class MessageToTypeMapper : NullableMapper<NotificationMessage, MessageType> {
    override fun map(data: NotificationMessage): MessageType? = MessageType.getEnum(data.messageType)
}