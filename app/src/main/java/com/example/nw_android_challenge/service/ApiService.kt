package com.example.nw_android_challenge.service

import com.example.nw_android_challenge.data.dto.PostDataDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    companion object {
        const val BASE_URL = "https://www.reddit.com/"
        const val POST = "r/all/top/.json"
    }

    @GET(POST)
    suspend fun getRedditPost(
        @Query("limit") loadSize: Int = 10,
        @Query("after") after: String? = null,
        @Query("before") before: String? = null
    ): Response<PostDataDto>
}