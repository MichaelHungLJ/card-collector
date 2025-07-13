package com.example.pokemoncardcollector.domain.repository

import com.example.pokemoncardcollector.domain.model.Card
import com.example.pokemoncardcollector.domain.model.CardSet

interface Repository {

    suspend fun getCardById(id: String): Card

    suspend fun getAllSets(): List<CardSet>
}
