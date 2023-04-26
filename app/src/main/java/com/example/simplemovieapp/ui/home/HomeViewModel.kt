package com.example.simplemovieapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.simplemovieapp.data.dto.MovieResponse
import com.example.simplemovieapp.domain.usecase.UpcomingUseCase
import com.example.simplemovieapp.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val upcomingUseCase: UpcomingUseCase,
) : BaseViewModel() {

    private val _upcomingMovie = MutableLiveData<PagingData<MovieResponse.Result>>()
    val upcomingMovie get() = _upcomingMovie

    init {
        viewModelScope.launch {
            upcomingUseCase.invoke().cachedIn(viewModelScope).collectLatest {
                _upcomingMovie.postValue(it)
            }
        }
    }

}