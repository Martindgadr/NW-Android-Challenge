package com.example.nw_android_challenge.commons.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel() {
    override fun onCleared() {
        super.onCleared()
        cancelRequest()
    }

    abstract fun cancelRequest()
}