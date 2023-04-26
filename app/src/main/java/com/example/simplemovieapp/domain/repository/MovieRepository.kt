package com.example.simplemovieapp.domain.repository

import androidx.paging.PagingData
import com.example.simplemovieapp.data.dto.MovieResponse
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getUpcomingMovies(): Flow<PagingData<MovieResponse.Result>>
}