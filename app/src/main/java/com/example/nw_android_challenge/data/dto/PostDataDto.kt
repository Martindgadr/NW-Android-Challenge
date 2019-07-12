package com.example.nw_android_challenge.data.dto

import com.example.nw_android_challenge.data.model.Post

data class PostDataDto (
    val children: List<Post>,
    val after: String?,
    val before: String?
){}