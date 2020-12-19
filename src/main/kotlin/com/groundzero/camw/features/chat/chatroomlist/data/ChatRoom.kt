package com.groundzero.camw.features.chat.chatroomlist.data

import com.groundzero.camw.core.data.NetworkModel

data class ChatRoom(
        override val itemId: String? = null,
        val title: String? = null,
        val subtitle: String? = null,
        val image: String? = null,
        val available: Boolean? = null,
        val sortIndex: Int? = null
): NetworkModel