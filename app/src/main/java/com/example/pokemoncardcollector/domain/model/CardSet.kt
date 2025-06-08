package com.example.pokemoncardcollector.domain.model

data class CardSet(
    val id: String,
    val name: String,
    val series: String,
    val printedTotal: Int,
    val images: CardSetImage
)

data class CardSetImage(
    val symbol: String,
    val logo: String
)


