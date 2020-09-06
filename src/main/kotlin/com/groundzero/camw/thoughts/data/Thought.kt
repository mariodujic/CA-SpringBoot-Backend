package com.groundzero.camw.thoughts.data

import com.groundzero.camw.data.NetworkModel

data class Thought(
        override val itemId: String? = null,
        val author: String? = null,
        val date: String? = null,
        val image: String? = null,
        val text: String? = null,
        val title: String? = null
) : NetworkModel