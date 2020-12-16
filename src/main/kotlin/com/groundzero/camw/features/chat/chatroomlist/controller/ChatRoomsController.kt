package com.groundzero.camw.features.chat.chatroomlist.controller

import com.groundzero.camw.core.base.BaseContentController
import com.groundzero.camw.core.base.BaseContentValidator
import com.groundzero.camw.features.chat.chatroomlist.data.ChatRoom
import com.groundzero.camw.features.chat.chatroomlist.data.ChatRoomDataType
import com.groundzero.camw.features.chat.chatroomlist.data.ChatRoomsRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/chat-rooms")
class ChatRoomsController(
        repository: ChatRoomsRepository,
        contentValidator: BaseContentValidator
) : BaseContentController<ChatRoom>(repository, contentValidator) {

    @GetMapping("/en")
    fun getChatRoomsEnglish() = getItemsResponse(ChatRoomDataType.English)

    @GetMapping("/en-staging")
    fun getChatRoomsEnglishStaging() = getItemsResponse(ChatRoomDataType.EnglishStaging)

    @GetMapping("/hr")
    fun getChatRoomssCroatian() = getItemsResponse(ChatRoomDataType.Croatian)

    @GetMapping("/hr-staging")
    fun getChatRoomssCroatianStaging() = getItemsResponse(ChatRoomDataType.CroatianStaging)

    @GetMapping("/sk")
    fun getChatRoomssSlovak() = getItemsResponse(ChatRoomDataType.Slovak)

    @GetMapping("/sk-staging")
    fun getChatRoomssSlovakStaging() = getItemsResponse(ChatRoomDataType.SlovakStaging)

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
}