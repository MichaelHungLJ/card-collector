package com.example.pokemoncardcollector.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.pokemoncardcollector.domain.model.Card
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokemoncardcollector.R
import com.example.pokemoncardcollector.domain.model.CardImage
import com.example.pokemoncardcollector.domain.model.CardSet
import com.example.pokemoncardcollector.domain.model.CardSetImage

@Composable
fun CardComponent(
    modifier: Modifier = Modifier.fillMaxWidth(),
    cardItem: Card,
) {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround,
    ) {

        CardImage(
            cardUrl = cardItem.images.large,
            modifier = Modifier.padding(top = 8.dp),
        )
        
        Spacer(modifier = Modifier.padding(8.dp))

        CardDetails(
            cardItem = cardItem,
            modifier = Modifier,
        )


    }
}

@Composable
fun CardImage(
    cardUrl: String,
    modifier: Modifier = Modifier
) {
    val isPreview = LocalInspectionMode.current

    if (isPreview) {
        Image(
            painter = painterResource(R.drawable.card_image_placeholder),
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    }
    else {
        AsyncImage(
            model = cardUrl,
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun CardDetails(
    cardItem: Card,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp)
        ){
            Text(
                text = "Name: ${cardItem.name}",
            )

            Text(
                text = "Rarity: ${cardItem.rarity}",
                textAlign = TextAlign.End,
            )
        }

        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp, 0.dp)
        ){

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CardSetIcon(url = cardItem.set.images.logo)
                Text(
                    text = "Set: ${cardItem.set.name}",
                    modifier = Modifier.padding(start = 4.dp),
                    textAlign = TextAlign.Left
                )
            }

            Text(text = "No: ${cardItem.number} / ${cardItem.set.printedTotal}")
        }
    }

}

@Composable
fun CardSetIcon(url: String, modifier: Modifier = Modifier) {
    val isInPreview = LocalInspectionMode.current

    if (isInPreview) {
        Image(
            painter = painterResource(id = R.drawable.card_set_logo_placeholder),
            contentDescription = null,
            modifier = modifier
                .size(40.dp)
        )
    } else {
        AsyncImage(
            model = url,
            contentDescription = null,
            modifier = modifier
                .size(40.dp),
            contentScale = ContentScale.Fit
        )
    }
}


@Preview(showBackground = true, widthDp = 300)
@Composable
fun CardComponentPreview() {
    CardComponent(
        cardItem = mockCard
    )
}

@Preview(showBackground = true, widthDp = 300)
@Composable
fun CardDetailsPreview() {
    CardDetails(
        cardItem = mockCard,
        modifier = Modifier
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


