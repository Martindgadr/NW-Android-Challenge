package com.example.nw_android_challenge.ui.mainpost.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.nw_android_challenge.commons.extensions.loadFromUrl
import com.example.nw_android_challenge.data.model.Post
import kotlinx.android.synthetic.main.item_post_cardview.view.*

class PostViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    fun bind(post: Post?, clickListener: (Post) -> Unit) {
        post?.let { itemPost ->
            // TODO Bind data to layout
            itemPost.imageUrl?.let { itemView.userImage.loadFromUrl(itemPost.imageUrl)}
            itemView.tv_title.text = itemPost.title
            itemView.tv_qty_comments.text = itemPost.comment.toString()
            itemView.setOnClickListener { clickListener(itemPost) }
        }
    }

}