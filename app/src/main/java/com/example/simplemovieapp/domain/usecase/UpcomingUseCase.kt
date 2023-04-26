package com.example.simplemovieapp.domain.usecase

import androidx.paging.PagingData
import com.example.simplemovieapp.data.dto.MovieResponse
import kotlinx.coroutines.flow.Flow

interface UpcomingUseCase {
    operator fun invoke(): Flow<PagingData<MovieResponse.Result>>
}