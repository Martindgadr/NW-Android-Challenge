package com.example.nw_android_challenge.service

import com.example.nw_android_challenge.data.dto.PostDataDto
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    companion object {
        const val BASE_URL = "https://www.reddit.com/r/all/top/"
        const val POST = ".json"
    }

    @GET(POST)
    suspend fun getRedditPost(): Response<PostDataDto>
}