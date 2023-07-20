package com.rbs.newsapp.common

sealed class NetworkStatus {
    object Unknown : NetworkStatus()
    object Connected : NetworkStatus()
    object Disconnected : NetworkStatus()
}
