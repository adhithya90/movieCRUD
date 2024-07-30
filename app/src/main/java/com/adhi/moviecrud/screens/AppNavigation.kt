package com.adhi.moviecrud.screens

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adhi.moviecrud.components.BottomNavigation
import com.adhi.moviecrud.navigation.MovieNavigation


@Composable
fun AppNavigation(movieViewModel: MovieViewModel) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigation(navController) }
    ) { innerPadding ->
        Surface(
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {
            val movies = movieViewModel.movieList.collectAsState().value
            NavHost(
                navController = navController,
                startDestination = MovieNavigation.Home.route

            ) {
                composable(MovieNavigation.Home.route) {
                    MovieListView(movies = movies)
                }
                composable(MovieNavigation.Add.route) {
                    AddNewMovie(movieViewModel)
                }

            }
        }
    }
}