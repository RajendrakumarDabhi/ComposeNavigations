package com.example.composenavigations

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composenavigations.ui.theme.ComposeNavigationsTheme
import com.example.composenavigations.utils.Constants.Companion.BOTTOM_NAVIGATION_SCREEN
import com.example.composenavigations.utils.Constants.Companion.LISTING_SCREEN
import com.example.composenavigations.utils.Constants.Companion.NAVIGATION_DRAWER_SCREEN
import com.example.composenavigations.views.BottomNavigation.BottomNavigationSample
import com.example.composenavigations.views.navigationdrawer.NavigationDrawerSample

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationsTheme {

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = LISTING_SCREEN) {

                    composable(NAVIGATION_DRAWER_SCREEN) {
                        NavigationDrawerSample()
                    }

                    composable(BOTTOM_NAVIGATION_SCREEN) {
                        BottomNavigationSample()
                    }

                    composable(LISTING_SCREEN) {
                        ListScreens(navController)
                    }

                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListScreens(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Navigation Demo",
                    style = TextStyle(fontSize = 16.sp, color = Color.White)
                )
            })
        }
    ) {
        LazyColumn(Modifier.padding(it)) {
            item {
                Card(
                    Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .padding(top = 10.dp, bottom = 10.dp)
                        .clickable {
                            navController.navigate(NAVIGATION_DRAWER_SCREEN)
                        }) {
                    Text(text = "Navigation Drawer",Modifier.fillMaxWidth())
                }
            }

            item {
                Card(Modifier.clickable {
                    navController.navigate(BOTTOM_NAVIGATION_SCREEN)
                }) {
                    Text(text = "Bottom Navigation")
                }
            }

        }
    }
}
