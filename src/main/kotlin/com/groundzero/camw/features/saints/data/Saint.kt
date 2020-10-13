package com.groundzero.camw.features.saints.data

import com.groundzero.camw.core.data.NetworkModel

data class Saint(
        override val itemId: String? = null,
        val title: String? = null,
        val text: String? = null,
        val image: String? = null,
) : NetworkModel