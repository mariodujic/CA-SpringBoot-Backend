package com.groundzero.camw.features.information.data

import com.groundzero.camw.core.data.NetworkModel
import com.groundzero.camw.utils.getUUID

data class InformationBlock(
        override val itemId: String = getUUID(),
        val title: String = "",
        val text: String = "",
        val informationType: Int? = null,
        val link: String = "",
        val image: String = "",
        val buttonText: String = ""
) : NetworkModel