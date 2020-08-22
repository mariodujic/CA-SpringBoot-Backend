package com.groundzero.camw.prayers.data

data class Prayer(
        val itemId: String? = null,
        val musicUrl: String? = null,
        val tag: String? = null,
        val text: String? = null,
        val title: String? = null,
        val type: Int? = null,
        val segmentedList: List<Segmented>? = null
) {
    override fun toString() =
            """
             Prayer{
                 itemId='$itemId',
                 musicUrl='$musicUrl',
                 tag='$tag',
                 text='$text',
                 title='$title',
                 type='$type',
                 segmentedList='$segmentedList'
            }
            """
}