package com.example.pokemoncardcollector.data.repository

import com.example.pokemoncardcollector.data.remote.CardApi
import com.example.pokemoncardcollector.domain.model.Card
import com.example.pokemoncardcollector.domain.repository.CardRepository
import javax.inject.Inject

class CardRepositoryImpl @Inject constructor(
    private val cardApi: CardApi
) : CardRepository {

    override suspend fun getCardById(id: String): Card {
        return cardApi.getCardById(id).data
    }
}
