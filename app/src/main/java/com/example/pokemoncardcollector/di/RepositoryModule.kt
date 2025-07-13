package com.example.pokemoncardcollector.di

import com.example.pokemoncardcollector.data.remote.CardApi
import com.example.pokemoncardcollector.data.remote.SetApi
import com.example.pokemoncardcollector.data.repository.RepositoryImpl
import com.example.pokemoncardcollector.domain.repository.Repository
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
    fun provideRepository(
        cardApi: CardApi,
        setApi: SetApi,
    ): Repository {
        return RepositoryImpl(cardApi, setApi)
    }
}
