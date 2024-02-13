package com.example.composenavigations.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.composenavigations.views.navigationdrawer.NavigationItem

class Constants {
    companion object {
        const val NAVIGATION_DRAWER_SCREEN = "navigation_drawer"
        const val BOTTOM_NAVIGATION_SCREEN = "bottom_navigation"
        const val LISTING_SCREEN = "list_screens"
        const val VIEWPAGER_SCREEN = "viewpager_screens"


        const val INFO = "Info"
        const val HOME = "Home"
        const val SETTINGS = "Settings"
        val NavigationItems = listOf(
            NavigationItem(
                title = INFO,
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home,
            ),
            NavigationItem(
                title = HOME,
                selectedIcon = Icons.Filled.Info,
                unselectedIcon = Icons.Outlined.Info,
                badgeCount = 45
            ),
            NavigationItem(
                title = SETTINGS,
                selectedIcon = Icons.Filled.Settings,
                unselectedIcon = Icons.Outlined.Settings,
            ),
        )
    }
}

sealed class BottomNavItems(val route: String, val icon: ImageVector, val label: String) {
    object Info : BottomNavItems("Info", Icons.Default.Info, "Info")
    object Home : BottomNavItems("Home", Icons.Default.Home, "Home")
    object Settings : BottomNavItems("Settings", Icons.Default.Settings, "Settings")
}