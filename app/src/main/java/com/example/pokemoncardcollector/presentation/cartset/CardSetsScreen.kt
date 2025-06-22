package com.example.pokemoncardcollector.presentation.cartset

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokemoncardcollector.domain.model.CardSet
import com.example.pokemoncardcollector.presentation.MockData
import com.example.pokemoncardcollector.presentation.components.CardSetListItem
import com.example.pokemoncardcollector.presentation.theme.PokemonCardCollectorTheme

@Composable
fun CardSetsScreen(
    modifier: Modifier = Modifier.fillMaxSize(),
    cardSetList: List<CardSet> = MockData.mockCardSets,
) {
    Surface (
        modifier = Modifier
    ) {
        LazyColumn {
            cardSetList.forEach {
                item { CardSetListItem(cardSet = it, onClick = {} ) }
            }
        }
    }
}


@Preview(showBackground = true, device = Devices.PIXEL_7)
@Composable
fun CardSetsScreenPreview() {
    PokemonCardCollectorTheme {
        CardSetsScreen(
            cardSetList = MockData.mockCardSets,
        )
    }
}
