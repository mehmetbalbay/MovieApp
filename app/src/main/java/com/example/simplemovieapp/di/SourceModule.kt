package com.example.simplemovieapp.di

import com.example.simplemovieapp.data.api.MovieApi
import com.example.simplemovieapp.data.source.RemoteDataSource
import com.example.simplemovieapp.data.source.RemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SourceModule {

    @Provides
    @Singleton
    fun provideRemoteSource(movieApi: MovieApi): RemoteDataSource {
        return RemoteDataSourceImpl(movieApi)
    }

}