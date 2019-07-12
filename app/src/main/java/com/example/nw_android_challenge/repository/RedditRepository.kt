package com.example.nw_android_challenge.repository

import com.example.nw_android_challenge.commons.utils.Failure
import com.example.nw_android_challenge.commons.utils.NetworkHandler
import com.example.nw_android_challenge.data.model.Post
import com.example.nw_android_challenge.service.RedditService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

interface RedditRepository {
    fun getPost(success: (stores: List<Post>) -> Unit, error: (failure: Failure) -> Unit)
    fun cancelJob()

    class RepositoryImplementation @Inject constructor(
        private val networkHandler: NetworkHandler,
        private val service: RedditService
    ): RedditRepository {
        private val mainJob = Job()
        private val uiScope = CoroutineScope(Dispatchers.Main + mainJob)

        override fun getPost(success: (stores: List<Post>) -> Unit, error: (failure: Failure) -> Unit) {
            when(networkHandler.isConnected) {
                true -> uiScope.launch {
                    service.getPost(
                        success = { success(it.dataList) },
                        error = { error(it) }
                    )
                }
            }
        }

        override fun cancelJob() = mainJob.cancel()
    }
}