package com.example.composenavigations.views.viewpagersample

import androidx.compose.material.icons.filled.Add
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.composenavigations.views.navigationdrawer.HomeScreen
import com.example.composenavigations.views.navigationdrawer.InfoScreen
import com.example.composenavigations.views.navigationdrawer.SettingsScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ViewPagerSample(navController: NavHostController) {
    val PAGE_SIZE = 3
    var pagerState = rememberPagerState(0) {
        PAGE_SIZE
    }
    val coroutineScope = rememberCoroutineScope()
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Tab Sample") },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                )
            }
        )

    }) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                modifier = Modifier.background(MaterialTheme.colorScheme.primary)
            ) {
                tabList.forEachIndexed { index, data ->
                    Tab(selected = pagerState.currentPage == index, modifier = Modifier,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.scrollToPage(index)
                            }

                        },
                        text = {
                            Text(
                                text = data.name,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        })
                }
            }
            HorizontalPager(pagerState) { pageNo ->
                when (pageNo) {
                    0 -> {
                        Column(
                            Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(48.dp))
                            Text(text = "You are on" + tabList.get(pageNo).name)
                        }
                    }

                    1 -> {
                        Column(
                            Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(48.dp))
                            Text(text = "You are on2" + tabList.get(pageNo).name)
                        }
                    }

                    2 -> {
                        Column(
                            Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Spacer(modifier = Modifier.height(48.dp))
                            Text(text = "You are on3" + tabList.get(pageNo).name)
                        }
                    }
                }
            }
        }
    }
}

val tabList = listOf<TabData>(
    TabData("Home", Icons.Default.Home),
    TabData("Info", Icons.Default.Info),
    TabData("Settings", Icons.Default.Settings)
)

data class TabData(val name: String, val icon: ImageVector)