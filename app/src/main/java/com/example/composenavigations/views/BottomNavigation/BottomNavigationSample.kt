package com.example.composenavigations.views.BottomNavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationSample() {
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(
            title = {
                Text(text = "White App")
            },
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(Icons.Filled.ArrowBack, "backIcon")
                }
            },
        )},
        bottomBar = {
            ScreenBottombar(
                navController, listOf(
                    BottomNavItem.Home,
                    BottomNavItem.Search,
                    BottomNavItem.Profile,

                    )
            )
        }
    )
    { padding ->
        Column(Modifier.padding(padding)) {
            Containers(navController = navController)
        }
    }
}

@Composable
private fun Containers(
    navController: NavHostController
) {
    NavHost(navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(text = "Home Screen")
            }
        }
        composable(BottomNavItem.Search.route) {
            Column(verticalArrangement = Arrangement.Center) {

                Text(text = "Search Screen")
            }
        }
        composable(BottomNavItem.Profile.route) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(text = "Profile Screen")
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    BottomNavigationSample()
}

@Composable
fun ScreenBottombar(navController: NavController, list: List<BottomNavItem>) {
    BottomNavigation(
        backgroundColor = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        list.forEach { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = "Home",
                        tint = Color.Black,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = { Text(text = item.label) },
                selected = true,
                onClick = {
                    navController.navigate(item.route)

                },
                alwaysShowLabel = false,
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray,
            )
        }
    }
}

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    object Search : BottomNavItem("search", Icons.Default.Search, "Search")
    object Profile : BottomNavItem("profile", Icons.Default.Person, "Profile")
}