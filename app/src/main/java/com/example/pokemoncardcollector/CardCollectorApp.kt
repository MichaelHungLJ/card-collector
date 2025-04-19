package com.example.pokemoncardcollector

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokemoncardcollector.ui.components.BottomBarNavigation

@Composable
fun CardCollectorApp() {

    val selectedNavigationIndex = rememberSaveable { mutableIntStateOf(0) }

    Scaffold (
        bottomBar = {
            BottomBarNavigation(
                selectedNavigationIndex = selectedNavigationIndex,
                onNavigationIndexSelected = { selectedNavigationIndex.intValue = it }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

        }
    }

}


@Preview(showBackground = true)
@Composable
fun CardCollectorAppPreview() {
    CardCollectorApp()
}
