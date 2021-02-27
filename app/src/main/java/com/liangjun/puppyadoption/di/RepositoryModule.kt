package com.liangjun.puppyadoption.di

import com.liangjun.puppyadoption.network.model.PuppyDtoMapper
import com.liangjun.puppyadoption.repository.PuppyRepository
import com.liangjun.puppyadoption.repository.PuppyRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePuppyRepository(mapper: PuppyDtoMapper): PuppyRepository {
        return PuppyRepositoryImpl(mapper)
    }
}