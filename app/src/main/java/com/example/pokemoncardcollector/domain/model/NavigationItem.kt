package com.example.pokemoncardcollector.domain.model

import androidx.annotation.DrawableRes

data class NavigationItem(
    val title: String,
    @DrawableRes val icon: Int,
    val route: String,
)
