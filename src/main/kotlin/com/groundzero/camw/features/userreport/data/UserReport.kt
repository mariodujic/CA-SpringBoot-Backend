package com.groundzero.camw.features.userreport.data

import com.groundzero.camw.core.data.NetworkModel

data class UserReport(
        override val itemId: String? = null,
        val message: String? = null,
        val item: ItemReport? = null,
        val itemType: Int = 4
) : NetworkModel {

    data class ItemReport(
            val itemId: String? = null,
            val title: String? = null
    )

    enum class ItemType(val type: Int) {
        PRAYER(0),
        THOUGHT(1),
        SAINT(2),
        QUIZ(3),
        NONE(4);

        companion object {
            fun findType(type: Int): ItemType? = values().find { it.type == type }
        }
    }
}