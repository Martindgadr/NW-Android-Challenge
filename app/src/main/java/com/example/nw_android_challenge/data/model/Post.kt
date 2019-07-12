package com.example.nw_android_challenge.data.model

data class Post(
    val title: String? = null,
    val author_fullname: String? = null,
    val thumbnail: String? = null,
    val created: Long? = null,
    val comments: Int, // TODO see where get this
    val postRead: Boolean
)