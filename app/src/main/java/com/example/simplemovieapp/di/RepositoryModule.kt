package com.example.simplemovieapp.di

import com.example.simplemovieapp.data.repository.MovieRepositoryImpl
import com.example.simplemovieapp.data.source.RemoteDataSource
import com.example.simplemovieapp.domain.repository.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(remoteDataSource: RemoteDataSource): MovieRepository {
        return MovieRepositoryImpl(remoteDataSource)
    }

}