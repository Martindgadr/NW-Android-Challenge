package com.example.nw_android_challenge.ui.mainpost.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.example.nw_android_challenge.R
import com.example.nw_android_challenge.commons.extensions.inflate
import com.example.nw_android_challenge.commons.utils.DiffUtilCallBack
import com.example.nw_android_challenge.data.model.Post

class PostAdapter: PagedListAdapter<Post, PostViewHolder>(DiffUtilCallBack()) {
    internal var onClickAction: ((Post) -> Unit) = { _ -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder =
        PostViewHolder(parent.inflate(R.layout.item_post_cardview))

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) =
        holder.bind(getItem(position), onClickAction)
}