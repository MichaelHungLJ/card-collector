package com.example.pokemoncardcollector.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.example.pokemoncardcollector.domain.model.Card
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.example.pokemoncardcollector.domain.model.CardImage
import com.example.pokemoncardcollector.domain.model.CardSet
import com.example.pokemoncardcollector.domain.model.CardSetImage

@Composable
fun CardComponent(
    modifier: Modifier = Modifier,
    cardItem: Card,
) {
    Column {

        AsyncImage(
            model = cardItem.images.large,
            contentDescription = "${cardItem.name}",
            modifier = modifier
        )

        Column {


        }

    }
}

@Preview(showBackground = true)
@Composable
fun CardComponentPreview() {
    CardComponent(
        modifier = Modifier,
        cardItem = mockCard
    )
}

private val mockCard = Card(
    id = "xy7-54",
    name = "Gardevoir EX",
    supertype = "Pokémon",
    subtypes = listOf("EX"),
    types = listOf("Fairy"),
    images = CardImage(
        small = "https://images.pokemontcg.io/xy7/54.png",
        large = "https://images.pokemontcg.io/xy7/54_hires.png"
    ),
    set = CardSet(
        id = "xy7",
        name = "Ancient Origins",
        series = "XY",
        printedTotal = 98,
        images = CardSetImage(
            symbol = "https://images.pokemontcg.io/xy7/symbol.png",
            logo = "https://images.pokemontcg.io/xy7/logo.png"
        )
    ),
    rarity = "Rare Holo EX",
    number = "54"
)


