package com.adhi.moviecrud.navigation

sealed class MovieNavigation(val route: String) {
    object Home : MovieNavigation("home")
    object Add : MovieNavigation("new")
}