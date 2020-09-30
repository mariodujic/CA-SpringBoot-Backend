package com.groundzero.camw.features.thoughts.data

import com.groundzero.camw.core.data.NetworkModel

data class Thought(
        override val itemId: String? = null,
        val author: String? = null,
        val date: String? = null,
        val image: String? = null,
        val text: String? = null,
        val title: String? = null
) : NetworkModel