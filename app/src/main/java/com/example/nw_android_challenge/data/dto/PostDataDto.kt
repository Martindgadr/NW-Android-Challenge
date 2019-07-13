package com.example.nw_android_challenge.data.dto

import com.example.nw_android_challenge.data.model.Post
import com.example.nw_android_challenge.data.model.PostHand

data class PostDataDto (
    val children: List<PostHand>,
    val after: String?,
    val before: String?
){}