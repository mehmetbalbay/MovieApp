package com.example.simplemovieapp.data.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.simplemovieapp.data.api.MovieApi
import com.example.simplemovieapp.data.dto.MoviesResponse
import retrofit2.HttpException
import java.io.IOException

class MoviePagingDataSource(private val movieApi: MovieApi) :
    PagingSource<Int, MoviesResponse.Result>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MoviesResponse.Result> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = movieApi.getUpcomingMovies(page)
            LoadResult.Page(
                data = response.results,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (response.results.isEmpty()) null else page + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, MoviesResponse.Result>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }

}
