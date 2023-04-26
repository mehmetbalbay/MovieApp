package com.example.simplemovieapp.di

import com.example.simplemovieapp.domain.repository.MovieRepository
import com.example.simplemovieapp.domain.usecase.UpcomingUseCase
import com.example.simplemovieapp.domain.usecase.UpcomingUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUpcomingUseCase(repository: MovieRepository): UpcomingUseCase {
        return UpcomingUseCaseImpl(repository)
    }

}