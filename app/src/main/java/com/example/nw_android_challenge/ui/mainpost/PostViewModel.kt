package com.example.nw_android_challenge.ui.mainpost

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.example.nw_android_challenge.commons.base.BaseViewModel
import com.example.nw_android_challenge.data.model.Post
import com.example.nw_android_challenge.repository.RedditDataSource
import javax.inject.Inject

class PostViewModel @Inject constructor(
    private val redditRepository: RedditDataSource
) : BaseViewModel() {
    val postData: LiveData<PagedList<Post>> get() = _postLiveData
    private val _postLiveData: LiveData<PagedList<Post>>

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(10)
            .setEnablePlaceholders(false)
            .build()

        _postLiveData = initPagedListBuilder(config).build()
    }

    private fun initPagedListBuilder(config: PagedList.Config):
            LivePagedListBuilder<String, Post> {

        val dataSourceFactory = object : DataSource.Factory<String, Post>() {
            override fun create(): DataSource<String, Post> {
                return redditRepository
            }
        }
        return LivePagedListBuilder<String, Post>(dataSourceFactory, config)
    }

    override fun cancelRequest() {
        redditRepository.cancelJob()
    }
}
