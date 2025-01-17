package com.adhi.moviecrud.screens


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.adhi.moviecrud.components.BottomNavigation
import com.adhi.moviecrud.navigation.MovieNavigation


@Composable
fun AppNavigation(movieViewModel: MovieViewModel) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigation(navController) }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            val movies = movieViewModel.movieList.collectAsState().value
            NavHost(
                navController = navController,
                startDestination = MovieNavigation.Home.route

            ) {
                composable(MovieNavigation.Home.route) {
                    MovieListView(navController, movies = movies, movieViewModel)
                }
                composable(MovieNavigation.Add.route) {
                    AddNewMovie(movieViewModel)
                }
                composable(
                    MovieNavigation.Edit.route, arguments = listOf(
                        navArgument("id") {
                            type = NavType.IntType
                        }
                    )
                ) { navBackStackEntry ->
                    val movieID = navBackStackEntry.arguments!!.getInt("id")
                    MovieEditScreen(navController, movieID, movieViewModel)

                }

            }
        }
    }
}