package com.example.pokemoncardcollector.di

import com.example.pokemoncardcollector.data.remote.CardApi
import com.example.pokemoncardcollector.data.repository.CardRepositoryImpl
import com.example.pokemoncardcollector.domain.repository.CardRepository
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
    fun provideCardRepository(
        cardApi: CardApi
    ): CardRepository {
        return CardRepositoryImpl(cardApi)
    }
}
