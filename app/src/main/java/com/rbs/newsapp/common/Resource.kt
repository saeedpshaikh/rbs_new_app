package com.rbs.newsapp.common

sealed class Resource<Any>(val data: Any? = null, val message: String? = null) {
    class Success<Any>(data: Any) : Resource<Any>(data)
    class Error<Any>(message: String, data: Any? = null) : Resource<Any>(data, message)
    class Loading<Any>(data: Any? = null) : Resource<Any>(data)
}