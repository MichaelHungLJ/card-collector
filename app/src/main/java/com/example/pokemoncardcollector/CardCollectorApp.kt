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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokemoncardcollector.domain.model.Screen
import com.example.pokemoncardcollector.ui.components.BottomBarNavigation
import com.example.pokemoncardcollector.ui.screens.CardSetsScreen
import com.example.pokemoncardcollector.ui.screens.HomeScreen
import com.example.pokemoncardcollector.ui.screens.ProfileScreen
import com.example.pokemoncardcollector.ui.screens.SearchScreen

@Composable
fun CardCollectorApp() {

    val navController = rememberNavController()
    val selectedNavigationIndex = rememberSaveable { mutableIntStateOf(0) }

    Scaffold (
        bottomBar = {
            BottomBarNavigation(
                selectedNavigationIndex = selectedNavigationIndex,
                onNavigationIndexSelected = { index ->
                    selectedNavigationIndex.intValue = index
                    when (index) {
                        0 -> navController.navigate(Screen.Home.route)
                        1 -> navController.navigate(Screen.CardSets.route)
                        2 -> navController.navigate(Screen.Search.route)
                        3 -> navController.navigate(Screen.Profile.route)
                    }
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(route = Screen.Home.route) {
                HomeScreen()
            }

            composable(route = Screen.CardSets.route) {
                CardSetsScreen()
            }

            composable(route = Screen.Search.route) {
                SearchScreen()
            }

            composable(route = Screen.Profile.route) {
                ProfileScreen()
            }

        }
    }

}


@Preview(showBackground = true)
@Composable
fun CardCollectorAppPreview() {
    CardCollectorApp()
}
