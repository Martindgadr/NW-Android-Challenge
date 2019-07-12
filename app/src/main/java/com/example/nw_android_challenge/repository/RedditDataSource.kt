package com.example.nw_android_challenge.repository

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.example.nw_android_challenge.commons.utils.NetworkHandler
import com.example.nw_android_challenge.data.model.Post
import com.example.nw_android_challenge.service.RedditService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Response.success
import javax.inject.Inject

class RedditDataSource @Inject constructor(
    private val networkHandler: NetworkHandler,
    private val service: RedditService
): PageKeyedDataSource<String, Post>() {
    private val mainJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + mainJob)

    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<String, Post>) {
        when(networkHandler.isConnected) {
            true -> uiScope.launch {
                service.getPost(
                    loadSize = params.requestedLoadSize,
                    after = "",
                    before = "",
                    success = {
                        success(it.children)
                        callback.onResult(it.children, it.before, it.after)
                    },
                    error = {
                        Log.e("Error GET", "Error gatting data from back")
                    }
                )
            }
        }
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, Post>) {
        when(networkHandler.isConnected) {
            true -> uiScope.launch {
                service.getPost(
                    loadSize = params.requestedLoadSize,
                    after = params.key,
                    before = "",
                    success = {
                        success(it.children)
                        callback.onResult(it.children, it.after)
                    },
                    error = {
                        Log.e("Error GET", "Error gatting data from back")
                    }
                )
            }
        }
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, Post>) {
        when(networkHandler.isConnected) {
            true -> uiScope.launch {
                service.getPost(
                    loadSize = params.requestedLoadSize,
                    after = "",
                    before = params.key,
                    success = {
                        success(it.children)
                        callback.onResult(it.children, it.after)
                    },
                    error = {
                        Log.e("Error GET", "Error gatting data from back")
                    }
                )
            }
        }
    }
}