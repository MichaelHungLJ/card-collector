package com.example.pokemoncardcollector.ui.components

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokemoncardcollector.domain.model.NavigationItem
import com.example.pokemoncardcollector.domain.model.Screen

@Composable
fun BottomBarNavigation(
    selectedNavigationIndex: MutableIntState,
    onNavigationIndexSelected: (Int) -> Unit
) {

    NavigationBar(
        containerColor = Color.White
    ) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedNavigationIndex.intValue == index,
                onClick = {
                    onNavigationIndexSelected(index)
                    // Add navigation here
                },
                icon = {
                    item.icon
                },
                label = {
                    Text(text = item.title)
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.inversePrimary
                )
            )
        }
    }

}


@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
fun BottomBarNavigationPreview() {
    BottomBarNavigation(
        selectedNavigationIndex = mutableIntStateOf(0),
        onNavigationIndexSelected = {}
    )
}

val navigationItems = listOf(
    NavigationItem(
        title = "Home",
        icon = Icons.Default,
        route = Screen.Home.route,
    ),
    NavigationItem(
        title = "Card Sets",
        icon = Icons.Default,
        route = Screen.CardSets.route,
    ),
    NavigationItem(
        title = "Search",
        icon = Icons.Default,
        route = Screen.Search.route,
    ),
    NavigationItem(
        title = "Profile",
        icon = Icons.Default,
        route = Screen.Profile.route,
    ),
)
