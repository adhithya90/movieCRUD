package com.adhi.moviecrud.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.adhi.moviecrud.components.MinimalInputField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieEditScreen(
    navController: NavController,
    movieID: Int,
    viewModel: MovieViewModel
) {
    val movie = viewModel.getMovie(movieID) ?: return Text(text = "Movie Not Found")

    var movieTitle by remember(movie.title) {
        mutableStateOf(movie.title)
    }

    Column() {
        TopAppBar(title = {
            Text(text = "Update movie")
        },
            actions = {
                Button(
                    onClick = {
                        viewModel.updateMovie(movie.copy(title = movieTitle))
                        navController.popBackStack()
                    },
                    enabled = movieTitle != movie.title,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Update movie")

                }
            })

        MinimalInputField(value = movieTitle,
            onValueChange = { movieTitle = it }
        )


    }

}