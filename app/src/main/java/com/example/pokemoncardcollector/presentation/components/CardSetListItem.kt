package com.example.pokemoncardcollector.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.AsyncImage
import com.example.pokemoncardcollector.R
import com.example.pokemoncardcollector.domain.model.CardSet
import com.example.pokemoncardcollector.domain.model.CardSetImage
import com.example.pokemoncardcollector.presentation.theme.PokemonCardCollectorTheme

@Composable
fun CardSetListItem (
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    cardSet: CardSet,
) {
    Card(
        modifier = modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        onClick = onClick,
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            CardSetImage(
                cardSetLogoUrl = cardSet.images.logo,
                modifier = Modifier
                    .size(64.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            Row (
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ) {

                Column (
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center,
                ) {
                    Text(
                        text = cardSet.name,
                        style = MaterialTheme.typography.titleMedium,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = cardSet.series,
                        style = MaterialTheme.typography.bodySmall,
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                CardCounter(
                    modifier = Modifier,
                    printedTotal = cardSet.printedTotal
                )
            }


        }
    }
}



@Composable
fun CardCounter(
    modifier: Modifier = Modifier,
    printedTotal: Int,
) {
    Text(
        text = "0/$printedTotal",
        modifier = modifier,
        style = MaterialTheme.typography.titleSmall,
        textAlign = TextAlign.Left,
    )
}

@Composable
fun CardSetDetails(
    cardSetName: String,
    cardSetSeries: String,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.Start,
    ) {

        Text(
            text = cardSetName,
            style = MaterialTheme.typography.titleMedium,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = cardSetSeries,
            style = MaterialTheme.typography.bodySmall,
        )

    }

}

@Composable
fun CardSetImage(
    cardSetLogoUrl: String,
    modifier: Modifier = Modifier
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


@Preview(showBackground = true)
@Composable
fun CardSetDetailsPreview() {
    CardSetDetails(
        cardSetName = mockCardSet.name,
        cardSetSeries = mockCardSet.series,
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
