package com.example.pokemoncardcollector.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardSet(
    @SerialName("id") val id: String,
    @SerialName("name") val name: String,
    @SerialName("series") val series: String,
    @SerialName("printedTotal") val printedTotal: Int,
    @SerialName("images") val images: CardSetImage
)

@Serializable
data class CardSetImage(
    @SerialName("symbol") val symbol: String,
    @SerialName("logo") val logo: String
)


