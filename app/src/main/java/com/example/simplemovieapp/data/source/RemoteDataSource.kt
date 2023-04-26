package com.example.simplemovieapp.data.source

import androidx.paging.PagingData
import com.example.simplemovieapp.data.dto.MovieResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getUpcomingMovies(): Flow<PagingData<MovieResponse.Result>>
}