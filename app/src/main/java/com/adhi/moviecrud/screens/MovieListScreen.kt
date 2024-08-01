package com.adhi.moviecrud.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete

import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import com.adhi.moviecrud.model.Movie


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListView(
    navController: NavController,
    movies: List<Movie>,
    movieViewModel: MovieViewModel
) {
    var isMultiSelectEnabled by remember { mutableStateOf(false) }
    Column() {
        TopAppBar(title = {
            Text(text = "Home")
        },
            actions = {
                if (isMultiSelectEnabled) {
                    IconButton(onClick = {
                        movieViewModel.deleteSelectedMovies()
                        isMultiSelectEnabled = false
                    }) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = "Delete selected movies"
                        )
                    }
                }
            })

        LazyColumn {
            items(movies.size) { movie ->
                val isSelected = movieViewModel.selectedMovieIDs.contains(movies[movie].id)
                MovieCard(
                    movie = movies[movie],
                    isSelected = isSelected,
                    isMultiSelectMode = isMultiSelectEnabled,
                    onMovieSelected = { movieViewModel.onMovieSelected(movies[movie].id, it) },
                    onEditClick = {
                        if (isMultiSelectEnabled) {
                            navController.navigate("edit/${movies[movie].id}")
                        }
                    },
                    onLongPress = { isMultiSelectEnabled = true })
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color.White.copy(alpha = 0.1f)
                )
            }
        }
    }
}

@Composable
fun MovieCard(
    movie: Movie,
    onEditClick: (Movie) -> Unit,
    onMovieSelected: (Boolean) -> Unit,
    isSelected: Boolean,
    isMultiSelectMode: Boolean,
    onLongPress: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clickable { onEditClick(movie) }
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = { onLongPress() }
                )
            }

    ) {
        if (isMultiSelectMode) {
            Checkbox(
                modifier = Modifier
                    .size(3.dp)
                    .align(Alignment.CenterVertically),
                checked = isSelected,
                onCheckedChange = { onMovieSelected(it) },
            )
            Spacer(modifier = Modifier.padding(horizontal = 8.dp))
        }
        Text(text = movie.title)
    }
}