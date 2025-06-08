package com.example.pokemoncardcollector.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokemoncardcollector.R
import com.example.pokemoncardcollector.domain.model.CardSet
import com.example.pokemoncardcollector.domain.model.CardSetImage
import com.example.pokemoncardcollector.ui.theme.PokemonCardCollectorTheme

@Composable
fun CardSetListItem (
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    cardSet: CardSet,
) {
    Column {
        Row (
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp)
            ,
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
        ){
            CardSetImage(cardSet.images.logo)

            Spacer(modifier = Modifier.width(4.dp))

            CardSetDetails(
                cardSetName = cardSet.name,
                printedTotal = cardSet.printedTotal,
                onClick = onClick,
                modifier = Modifier.weight(1f)
            )

        }


    }
}

@Composable
fun CardSetDetails(
    cardSetName: String,
    printedTotal: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Row (
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = cardSetName,
            style = MaterialTheme.typography.titleMedium,
            modifier = modifier.padding(start = 16.dp)
        )

        Text(
            text = "Total cards: $printedTotal",
            style = MaterialTheme.typography.bodyMedium,
                modifier = modifier.padding(start = 24.dp)
        )

        TextButton(
            onClick = onClick,
            modifier = modifier
                .size(40.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = "More info"
            )
        }


    }

}

@Composable
fun CardSetImage(
    cardSetLogoUrl: String,
    modifier: Modifier = Modifier
        .size(80.dp)
        .clip(RoundedCornerShape(8.dp))
) {
    val isPreview = LocalInspectionMode.current

    if (isPreview) {
        Image(
            painter = painterResource(R.drawable.card_set_image_placeholder),
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Fit
        )
    } else {
        AsyncImage(
            model = cardSetLogoUrl,
            contentDescription = null,
            modifier = modifier,
            contentScale = ContentScale.Fit
        )
    }
}




@Preview(showBackground = true)
@Composable
fun CardSetListItemPreview() {
    PokemonCardCollectorTheme {
        CardSetListItem(
            cardSet = mockCardSet,
            onClick = {}
        )
    }
}


@Preview(showBackground = true, widthDp = 400)
@Composable
fun CardSetDetailsPreview() {
    CardSetDetails(
        cardSetName = mockCardSet.name,
        printedTotal = mockCardSet.printedTotal,
        onClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun CardSetImagePreview() {
    CardSetImage(
        cardSetLogoUrl = mockCardSet.images.logo
    )
}


private val mockCardSet = CardSet(
    id = "sv8pt5",
    name = "Prismatic Evolutions",
    series = "Scarlet & Violet",
    printedTotal = 131,
    images = CardSetImage(
        symbol = "https://images.pokemontcg.io/sv8pt5/symbol.png",
        logo = "https://images.pokemontcg.io/sv8pt5/logo.png",
    )
)
