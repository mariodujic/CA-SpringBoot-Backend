package com.groundzero.camw.features.chat.chatroom.controller

import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessage
import com.groundzero.camw.features.chat.chatroom.network.ChatRoomMessageRequest
import com.groundzero.camw.features.chat.chatroom.service.ChatRoomMessagesService
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.RestController

@RestController
class ChatRoomMessagesController(private val chatRoomService: ChatRoomMessagesService) {

    @MessageMapping("/insert/{itemId}")
    @SendTo("/room/{itemId}")
    fun insertRoomMessage(
        @DestinationVariable(value = "itemId") roomId: String,
        messageRequest: ChatRoomMessageRequest
    ): List<ChatRoomMessage> {
        chatRoomService.insertMessage(roomId, messageRequest)
        return chatRoomService.getMessagesPerRoomId(roomId = roomId)
    }

    @MessageMapping("/update/{itemId}")
    @SendTo("/room/{itemId}")
    fun updateRoomMessage(
        @DestinationVariable(value = "itemId") roomId: String,
        messageRequest: ChatRoomMessageRequest
    ): List<ChatRoomMessage> {
        chatRoomService.updateMessage(roomId, messageRequest)
        return chatRoomService.getMessagesPerRoomId(roomId = roomId)
    }

    @MessageMapping("/delete/{itemId}/{messageId}")
    @SendTo("/room/{itemId}")
    fun removeRoomMessage(
        @DestinationVariable(value = "itemId") roomId: String,
        @DestinationVariable(value = "messageId") messageId: String
    ): List<ChatRoomMessage> {
        chatRoomService.deleteMessage(roomId, messageId)
        return chatRoomService.getMessagesPerRoomId(roomId = roomId)
    }

    @MessageMapping("/get/{itemId}")
    @SendTo("/room/{itemId}")
    fun sendRoomMessage(
        @DestinationVariable(value = "itemId") roomId: String,
    ): List<ChatRoomMessage> = chatRoomService.getMessagesPerRoomId(roomId = roomId)
}