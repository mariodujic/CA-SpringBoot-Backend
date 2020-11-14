package com.groundzero.camw.features.messaging.controller

import com.groundzero.camw.core.data.DataType
import com.groundzero.camw.core.network.NetworkResponse
import com.groundzero.camw.features.messaging.data.NotificationRequest
import com.groundzero.camw.features.messaging.service.MessagingService
import com.groundzero.camw.features.thoughts.constants.ThoughtDataType
import com.groundzero.camw.utils.code
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/message")
class MessagingController(private val messagingService: MessagingService) {

    @PostMapping("/en-notifications")
    fun sendEnglishMessage(@RequestBody notificationRequest: NotificationRequest): NetworkResponse = sendMessage(notificationRequest, ThoughtDataType.English)

    @PostMapping("/en-notifications-staging")
    fun sendEnglishStagingMessage(@RequestBody notificationRequest: NotificationRequest): NetworkResponse = sendMessage(notificationRequest, ThoughtDataType.EnglishStaging)

    @PostMapping("/hr-notifications")
    fun sendCroatianMessage(@RequestBody notificationRequest: NotificationRequest): NetworkResponse = sendMessage(notificationRequest, ThoughtDataType.Croatian)

    @PostMapping("/hr-notifications-staging")
    fun sendCroatianStagingMessage(@RequestBody notificationRequest: NotificationRequest): NetworkResponse = sendMessage(notificationRequest, ThoughtDataType.CroatianStaging)

    private fun sendMessage(notificationRequest: NotificationRequest, dataType: DataType): NetworkResponse {
        messagingService.sendMessage(notificationRequest, dataType)
        return NetworkResponse.Success<Nothing>(code(HttpStatus.OK), "Message sent successfully")
    }
}