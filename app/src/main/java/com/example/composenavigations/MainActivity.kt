package com.example.composenavigations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigations.ui.theme.ComposeNavigationsTheme
import com.example.composenavigations.views.BottomNavigation.BottomNavigationSample
import com.example.composenavigations.views.navigationdrawer.NavigationDrawerSample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationsTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "bottom_navigation") {

                    composable("navigation_drawer") {
                        NavigationDrawerSample()
                    }

                    composable("bottom_navigation") {
                        BottomNavigationSample()
                    }
                }
            }
        }
    }
}
