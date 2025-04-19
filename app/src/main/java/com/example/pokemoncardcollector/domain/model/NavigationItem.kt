package com.example.pokemoncardcollector.domain.model

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons

data class NavigationItem(
    val title: String,
    @DrawableRes val icon: Int,
    val route: String,
)
