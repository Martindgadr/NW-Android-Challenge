package com.example.nw_android_challenge.data.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("name")
    val name: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("thumbnail")
    val imageUrl: String?,
    @SerializedName("author_fullname")
    val author: String?,
    @SerializedName("num_comments")
    val comment: Int?,
    @SerializedName("created")
    val createdDate: Long?,
    val postRead: Boolean
)