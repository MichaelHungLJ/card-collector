package com.example.pokemoncardcollector.data.remote

import com.example.pokemoncardcollector.domain.model.Card
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardResponse (
    @SerialName("data") val data: Card
)
