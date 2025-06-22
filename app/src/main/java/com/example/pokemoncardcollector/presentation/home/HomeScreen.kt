package com.example.pokemoncardcollector.presentation.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()

    val card = viewModel.card.value

    if (card != null) {
        Text(text = card.name)
    } else {
        Text(
            text = "Home"
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
