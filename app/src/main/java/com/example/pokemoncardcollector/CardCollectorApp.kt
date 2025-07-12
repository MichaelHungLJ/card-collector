package com.example.pokemoncardcollector

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pokemoncardcollector.domain.model.Screen
import com.example.pokemoncardcollector.presentation.cartset.CardSetsScreen
import com.example.pokemoncardcollector.presentation.components.BottomBarNavigation
import com.example.pokemoncardcollector.presentation.home.HomeScreen
import com.example.pokemoncardcollector.presentation.profile.ProfileScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardCollectorApp() {

    val navController = rememberNavController()
    val selectedNavigationIndex = rememberSaveable { mutableIntStateOf(0) }

    val navBackStackEntry = navController.currentBackStackEntryAsState().value
    val currentRoute = navBackStackEntry?.destination?.route

    val bottomNavRoutes = listOf(
        Screen.Home.route,
        Screen.CardSets.route,
        Screen.Profile.route
    )

    val showBackButton = currentRoute !in bottomNavRoutes

    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Pokemon Card Collector" , maxLines = 1) },
                navigationIcon = {
                    if (showBackButton) {
                        IconButton(
                            onClick = { navController.popBackStack() }
                        ) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                                contentDescription = "Go Back"
                            )
                        }
                    } else null
                },
                scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
            )
        },
        bottomBar = {
            BottomBarNavigation(
                selectedNavigationIndex = selectedNavigationIndex,
                onNavigationIndexSelected = { index ->
                    selectedNavigationIndex.intValue = index
                    when (index) {
                        0 -> navController.navigate(Screen.Home.route)
                        1 -> navController.navigate(Screen.CardSets.route)
                        2 -> navController.navigate(Screen.Profile.route)
                    }
                }
            )
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            composable(route = Screen.Home.route) {
                HomeScreen()
            }

            composable(route = Screen.CardSets.route) {
                CardSetsScreen()
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
