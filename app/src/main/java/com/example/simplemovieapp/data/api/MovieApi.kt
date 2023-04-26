package com.example.simplemovieapp.data.api

import com.example.simplemovieapp.data.dto.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("page") page: Int): MovieResponse
}