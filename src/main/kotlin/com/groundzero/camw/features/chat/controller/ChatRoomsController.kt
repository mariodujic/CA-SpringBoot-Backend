package com.groundzero.camw.features.chat.controller

import com.groundzero.camw.core.base.BaseConfigController
import com.groundzero.camw.features.chat.data.ChatRoom
import com.groundzero.camw.features.chat.data.ChatRoomDataType
import com.groundzero.camw.features.chat.data.ChatRoomsRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/chat-rooms")
class ChatRoomsController(repository: ChatRoomsRepository) : BaseConfigController<List<ChatRoom>>(repository) {

    @GetMapping("/en")
    fun getAdConfigEnglish() = getItemsResponse(ChatRoomDataType.English)

    @GetMapping("/en-staging")
    fun getAdConfigEnglishStaging() = getItemsResponse(ChatRoomDataType.EnglishStaging)

    @GetMapping("/hr")
    fun getAdConfigsCroatian() = getItemsResponse(ChatRoomDataType.Croatian)

    @GetMapping("/hr-staging")
    fun getAdConfigsCroatianStaging() = getItemsResponse(ChatRoomDataType.CroatianStaging)

    @GetMapping("/sk")
    fun getAdConfigsSlovak() = getItemsResponse(ChatRoomDataType.Slovak)

    @GetMapping("/sk-staging")
    fun getAdConfigsSlovakStaging() = getItemsResponse(ChatRoomDataType.SlovakStaging)
}