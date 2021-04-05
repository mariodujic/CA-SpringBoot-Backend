package com.groundzero.camw.features.chat.chatroomlist.controller

import com.groundzero.camw.core.base.BaseContentController
import com.groundzero.camw.core.base.BaseContentValidator
import com.groundzero.camw.features.chat.chatroomlist.data.ChatRoom
import com.groundzero.camw.features.chat.chatroomlist.data.ChatRoomDataType
import com.groundzero.camw.features.chat.chatroomlist.data.ChatRoomListRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/chat-rooms")
class ChatRoomListController(
        repository: ChatRoomListRepository,
        contentValidator: BaseContentValidator
) : BaseContentController<ChatRoom>(repository, contentValidator) {

    @GetMapping("/en")
    fun getChatRoomsEnglish() = getItemsResponse(ChatRoomDataType.English)

    @GetMapping("/en-staging")
    fun getChatRoomsEnglishStaging() = getItemsResponse(ChatRoomDataType.EnglishStaging)

    @GetMapping("/hr")
    fun getChatRoomsCroatian() = getItemsResponse(ChatRoomDataType.Croatian)

    @GetMapping("/hr-staging")
    fun getChatRoomsCroatianStaging() = getItemsResponse(ChatRoomDataType.CroatianStaging)

    @GetMapping("/sk")
    fun getChatRoomsSlovak() = getItemsResponse(ChatRoomDataType.Slovak)

    @GetMapping("/sk-staging")
    fun getChatRoomsSlovakStaging() = getItemsResponse(ChatRoomDataType.SlovakStaging)

    @GetMapping("/es")
    fun getChatRoomsSpanish() = getItemsResponse(ChatRoomDataType.Spanish)

    @GetMapping("/es-staging")
    fun getChatRoomsSpanishStaging() = getItemsResponse(ChatRoomDataType.SpanishStaging)

    @PostMapping("/en")
    fun postChatRoomEnglish(@RequestBody chatRoom: ChatRoom) = addItemResponse(chatRoom, ChatRoomDataType.English)

    @PostMapping("/en-staging")
    fun postChatRoomEnglishStaging(@RequestBody chatRoom: ChatRoom) = addItemResponse(chatRoom, ChatRoomDataType.EnglishStaging)

    @PostMapping("/hr")
    fun postChatRoomCroatian(@RequestBody chatRoom: ChatRoom) = addItemResponse(chatRoom, ChatRoomDataType.Croatian)

    @PostMapping("/hr-staging")
    fun postChatRoomCroatianStaging(@RequestBody chatRoom: ChatRoom) = addItemResponse(chatRoom, ChatRoomDataType.CroatianStaging)

    @PostMapping("/sk")
    fun postChatRoomSlovak(@RequestBody chatRoom: ChatRoom) = addItemResponse(chatRoom, ChatRoomDataType.Slovak)

    @PostMapping("/sk-staging")
    fun postChatRoomSlovakStaging(@RequestBody chatRoom: ChatRoom) = addItemResponse(chatRoom, ChatRoomDataType.SlovakStaging)

    @PostMapping("/es")
    fun postChatRoomSpanish(@RequestBody chatRoom: ChatRoom) = addItemResponse(chatRoom, ChatRoomDataType.Spanish)

    @PostMapping("/es-staging")
    fun postChatRoomSpanishStaging(@RequestBody chatRoom: ChatRoom) = addItemResponse(chatRoom, ChatRoomDataType.SpanishStaging)
}