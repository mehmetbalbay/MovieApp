package com.example.simplemovieapp.domain.usecase

import androidx.paging.PagingData
import com.example.simplemovieapp.data.dto.MovieResponse
import com.example.simplemovieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UpcomingUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepository
) : UpcomingUseCase {
    override fun invoke(): Flow<PagingData<MovieResponse.Result>> =
        movieRepository.getUpcomingMovies()
}