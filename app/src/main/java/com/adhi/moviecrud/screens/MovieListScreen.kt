package com.adhi.moviecrud.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.adhi.moviecrud.model.Movie


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListView(navController: NavController, movies: List<Movie>) {
    Column() {
        TopAppBar(title = {
            Text(text = "Home")
        })

        LazyColumn {
            items(movies.size) { movie ->
                MovieCard(
                    movie = movies[movie],
                    onEditClick = { navController.navigate("edit/${movies[movie].id}") },
                    onDeleteClick = { })
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
    onDeleteClick: (Movie) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onEditClick(movie) }
            .padding(20.dp)
    ) {
        Text(text = movie.title)
    }
}