package com.example.pokemoncardcollector.data.repository

import com.example.pokemoncardcollector.data.remote.CardApi
import com.example.pokemoncardcollector.data.remote.SetApi
import com.example.pokemoncardcollector.domain.model.Card
import com.example.pokemoncardcollector.domain.model.CardSet
import com.example.pokemoncardcollector.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val cardApi: CardApi,
    private val setApi: SetApi
) : Repository {

    // Cards

    override suspend fun getCardById(id: String): Card {
        return cardApi.getCardById(id).data
    }


    // Sets

    override suspend fun getAllSets(): List<CardSet> {
        return setApi.getAllSets().data
    }
}
