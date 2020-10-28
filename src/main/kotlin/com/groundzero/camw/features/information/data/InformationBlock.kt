package com.groundzero.camw.features.information.data

import com.groundzero.camw.core.data.NetworkModel
import com.groundzero.camw.utils.getUUID

data class InformationBlock(
        override val itemId: String = getUUID(),
        val title: String = "",
        val text: String = "",
        /**
         * 0 -> Title with text
         * 1 -> Image
         * 2 -> Button for WebView
         */
        val informationType: Int? = null,
        val link: String = "",
        val image: String = "",
        val imageHeight: Int? = null,
        /**
         * 0 -> centerCrop
         * 1 -> fitCenter
         */
        val imageScaleType: Int? = null,
        val buttonText: String = "",
        /**
         * 0 -> wrapContent
         * 1 -> matchWidth
         */
        val buttonWidth: Int = 0,
        /**
         * 0 -> left
         * 1 -> center
         * 2 -> right
         */
        val buttonGravity: Int = 0,
        /**
         * Client InformationBlock list will be sorted by this index.
         */
        val sortIndex: Int = 0
) : NetworkModel