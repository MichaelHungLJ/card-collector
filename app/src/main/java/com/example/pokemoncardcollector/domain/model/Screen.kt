package com.example.pokemoncardcollector.domain.model

sealed class Screen(val route: String) {

    object Home : Screen("home_screen")
    object CardSets : Screen("card_sets_screen")
    object Profile : Screen("profile_screen")
    object Search : Screen("search_screen")
}
