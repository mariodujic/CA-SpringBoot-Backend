package com.groundzero.camw.prayers.data

import com.groundzero.camw.core.data.NetworkModel

data class Prayer(
        override val itemId: String? = null,
        val musicUrl: String? = null,
        val tag: String? = null,
        val text: String? = null,
        val title: String? = null,
        val type: Int? = null,
        val segmentedList: List<Segmented>? = null
) : NetworkModel