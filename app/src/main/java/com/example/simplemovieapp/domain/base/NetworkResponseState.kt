package com.example.simplemovieapp.domain.base

sealed class NetworkResponseState<out T : Any> {
    data class Success<out T : Any>(val data: T) : NetworkResponseState<T>()
    data class Error(val errorMessage: String) : NetworkResponseState<Nothing>()
    object Loading : NetworkResponseState<Nothing>()
}