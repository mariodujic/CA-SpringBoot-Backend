package com.groundzero.camw.thoughts.data

data class Thought(
        val author: String? = null,
        val date: String? = null,
        val image: String? = null,
        val itemId: String? = null,
        val text: String? = null,
        val title: String? = null
) {
    override fun toString() =
            """
                {
                author='$author',
                date='$date',
                image='$image',
                itemId='$itemId',
                text='$text',
                title='$title'
            """
}