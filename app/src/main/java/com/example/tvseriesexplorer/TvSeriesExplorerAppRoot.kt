package com.example.tvseriesexplorer

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tvseriesexplorer.ui.details.DetailsScreen
import com.example.tvseriesexplorer.ui.home.HomeScreen
import com.example.tvseriesexplorer.ui.navigation.NavRoutes

@Composable
fun TvSeriesExplorerAppRoot() {
    val navController = rememberNavController()

    Surface(color = MaterialTheme.colorScheme.background) {
        NavHost(
            navController = navController,
            startDestination = NavRoutes.HOME
        ) {
            composable(NavRoutes.HOME) {
                HomeScreen(
                    onShowClick = { showId ->
                        navController.navigate(NavRoutes.details(showId))
                    }
                )
            }

            composable(NavRoutes.DETAILS) { backStackEntry ->
                val showId = backStackEntry.arguments?.getString("showId") ?: ""
                DetailsScreen(
                    showId = showId,
                    onBack = { navController.navigateUp() }
                )
            }
        }
    }
}
