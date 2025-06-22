package com.example.pokemoncardcollector.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Card(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("supertype") val supertype: String,
    @SerialName("subtypes") val subtypes: List<String>,
    @SerialName("types") val types: List<String>?,
    @SerialName("images") val images: CardImage,
    @SerialName("set") val set: CardSet,
    @SerialName("rarity") val rarity: String,
    @SerialName("number") val number: String, // Api response is string, but we should use integer
)

@Serializable
data class CardImage(
    @SerialName("small") val small: String,
    @SerialName("large") val large: String
)

