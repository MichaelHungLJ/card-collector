package com.example.pokemoncardcollector.domain.repository

import com.example.pokemoncardcollector.data.remote.CardApi
import com.example.pokemoncardcollector.domain.model.Card
import javax.inject.Inject

interface CardRepository {

    suspend fun getCardById(id: String): Card
}
