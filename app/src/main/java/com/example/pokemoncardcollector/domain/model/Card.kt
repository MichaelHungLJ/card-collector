package com.example.pokemoncardcollector.domain.model

data class Card(
    val id: String,
    val name: String,
    val supertype: String,
    val subtypes: List<String>,
    val types: List<String>,
    val images: CardImage,
    val set: CardSet,
    val rarity: String,
    val number: String, // Api response is string, but we should use integer
)

data class CardImage(
    val small: String,
    val large: String
)

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

