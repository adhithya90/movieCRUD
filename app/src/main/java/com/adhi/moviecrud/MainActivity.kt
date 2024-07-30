package com.adhi.moviecrud

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adhi.moviecrud.screens.AppNavigation
import com.adhi.moviecrud.screens.MovieViewModel
import com.adhi.moviecrud.ui.theme.MovieCRUDTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieCRUDTheme {
                val movieViewModel: MovieViewModel = viewModel<MovieViewModel>()
                AppNavigation(movieViewModel)
            }
        }
    }
}

