package com.example.pokemoncardcollector.data.remote

import com.example.pokemoncardcollector.domain.model.CardSet
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SetResponse(
    @SerialName("data") val data: List<CardSet>
)
