package com.example.nw_android_challenge.commons.utils

import android.content.Context
import com.example.nw_android_challenge.commons.extensions.networkState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkHandler @Inject constructor(private val context: Context) {
    val isConnected get() = context.networkState?.isConnected
}