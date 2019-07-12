package com.example.nw_android_challenge.commons.di.module

import com.example.nw_android_challenge.repository.RedditRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun providesRepository(sourceRepository: RedditRepository.RepositoryImplementation)
            : RedditRepository = sourceRepository

}