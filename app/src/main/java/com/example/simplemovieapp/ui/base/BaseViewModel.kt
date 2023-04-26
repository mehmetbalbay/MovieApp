package com.example.simplemovieapp.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    protected fun setLoading(isLoading: Boolean) {
        _loading.value = isLoading
    }

    protected fun setErrorMessage(message: String) {
        _errorMessage.value = message
    }

    override fun onCleared() {
        super.onCleared()
    }

}