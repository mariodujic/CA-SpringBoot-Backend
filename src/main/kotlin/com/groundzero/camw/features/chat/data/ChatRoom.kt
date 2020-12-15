package com.groundzero.camw.features.chat.data

import com.groundzero.camw.core.data.NetworkModel

data class ChatRoom(
        override val itemId: String? = null,
        val title: String? = null,
        val subtitle: String? = null,
        val image: String? = null,
        val available: Boolean? = null
): NetworkModel