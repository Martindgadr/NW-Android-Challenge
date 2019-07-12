package com.example.nw_android_challenge.commons.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.nw_android_challenge.data.model.Post

class DiffUtilCallBack : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.title == newItem.title
                && oldItem.createdDate == newItem.createdDate
                && oldItem.comment == newItem.comment
        //return oldItem == newItem
    }
}