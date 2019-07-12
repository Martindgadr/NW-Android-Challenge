package com.example.nw_android_challenge.commons.utils

sealed class Failure {
    object NetworkConnection : Failure()
    object ServerError : Failure()
    object NoDataAvailable: Failure()
}