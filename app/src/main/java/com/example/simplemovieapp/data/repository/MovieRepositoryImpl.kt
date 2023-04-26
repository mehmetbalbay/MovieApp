package com.example.simplemovieapp.data.repository

import androidx.paging.PagingData
import com.example.simplemovieapp.data.dto.MovieResponse
import com.example.simplemovieapp.data.source.RemoteDataSource
import com.example.simplemovieapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
) : MovieRepository {

    override fun getUpcomingMovies(): Flow<PagingData<MovieResponse.Result>> {
        return remoteDataSource.getUpcomingMovies()
    }

}