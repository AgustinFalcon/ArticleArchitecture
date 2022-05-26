package com.example.articlescleanarchitecture.data.remote

import retrofit2.Response
import java.lang.Exception


sealed class NetResultState <out T> {
    data class Success<out T>(val data: T) : NetResultState<T>()
    data class Error(val exception: Exception): NetResultState<Nothing>()
    data class ErrorNetwork(val error: Response<*>, var code: Int? = null) : NetResultState<Nothing>()
    object Loading: NetResultState<Nothing>()
}