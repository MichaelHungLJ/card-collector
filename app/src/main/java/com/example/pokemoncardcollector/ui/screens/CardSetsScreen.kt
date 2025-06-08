package com.example.pokemoncardcollector.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CardSetsScreen(
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Text(
        text = "CardSets"
    )
}


@Preview(showBackground = true)
@Composable
fun CardSetsScreenPreview() {
    CardSetsScreen()
}
