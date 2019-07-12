package com.example.nw_android_challenge.service

import com.example.nw_android_challenge.commons.utils.Failure
import com.example.nw_android_challenge.data.dto.PostDataDto
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RedditService @Inject constructor(retrofit: Retrofit) {
    private val redditApi by lazy { retrofit.create(ApiService::class.java) }

    suspend fun getPost(success: (stores: PostDataDto) -> Unit, error: (failure: Failure) -> Unit) {
        try {
            val response = redditApi.getRedditPost()
            if (response.isSuccessful) {
                response.body()?.let{
                    success(it)
                } ?: error(Failure.NoDataAvailable)
            } else
                error(Failure.ServerError)
        } catch (e: Exception) {
            error(Failure.ServerError)
        }
    }
}