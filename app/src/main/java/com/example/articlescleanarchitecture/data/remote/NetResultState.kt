package com.example.articlescleanarchitecture.data.remote

import java.lang.Exception


sealed class NetResultState <out T> {
    data class Success<out T>(val data: T) : NetResultState<T>()
    data class Error(val error: Exception) : NetResultState<Nothing>()
    object Loading: NetResultState<Nothing>()
}