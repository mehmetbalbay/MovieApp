package com.example.simplemovieapp.data.source

import androidx.paging.PagingData
import com.example.simplemovieapp.data.dto.MoviesResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getUpcomingMovies(): Flow<PagingData<MoviesResponse.Result>>
}