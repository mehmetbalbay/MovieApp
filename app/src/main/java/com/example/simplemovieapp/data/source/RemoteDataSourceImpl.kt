package com.example.simplemovieapp.data.source

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.simplemovieapp.data.api.MovieApi
import com.example.simplemovieapp.data.dto.MoviesResponse
import com.example.simplemovieapp.data.repository.MoviePagingDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val movieApi: MovieApi
) : RemoteDataSource {
    override fun getUpcomingMovies(): Flow<PagingData<MoviesResponse.Result>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20
            ),
            pagingSourceFactory = { MoviePagingDataSource(movieApi) }
        ).flow
    }

}