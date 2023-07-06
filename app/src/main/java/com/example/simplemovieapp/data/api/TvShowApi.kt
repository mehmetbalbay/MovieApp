package com.example.simplemovieapp.data.api

import com.example.simplemovieapp.data.dto.TvShowsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TvShowApi {

    @GET("tv/airing_today")
    suspend fun getAiringTodayTvShows(@Query("page") page: Int): TvShowsResponse

    @GET("tv/on_the_air")
    suspend fun getOnTheAirTvShows(@Query("page") page: Int): TvShowsResponse

    @GET("tv/popular")
    suspend fun getPopularTvShows(@Query("page") page: Int): TvShowsResponse

    @GET("tv/top_rated")
    suspend fun getTopRatedTvShows(@Query("page") page: Int): TvShowsResponse

}