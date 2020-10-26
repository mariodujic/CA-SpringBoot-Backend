package com.groundzero.camw.features.information.data

import com.fasterxml.jackson.annotation.JsonProperty

data class InformationBlock(
        val title: String = "",
        val text: String = "",
        @JsonProperty("information_type")
        val informationType: Int? = null,
        val link: String = "",
        val image: String = "",
        @JsonProperty("button_text")
        val buttonText: String = ""
)