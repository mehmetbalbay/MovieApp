package com.example.simplemovieapp.domain.repository

import androidx.paging.PagingData
import com.example.simplemovieapp.data.dto.MoviesResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getUpcomingMovies(): Flow<PagingData<MoviesResponse.Result>>
}