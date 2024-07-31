package com.adhi.moviecrud.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.adhi.moviecrud.components.MinimalInputField


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewMovie(
    viewModel: MovieViewModel
) {
    Column() {
        TopAppBar(title = {
            Text(text = "Add new movie")
        },
            actions = {
                Button(
                    onClick = { viewModel.addMovie() },
                    enabled = viewModel.newMovieTitle.isNotBlank(),
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Add movie")

                }
            })

        MinimalInputField(value = viewModel.newMovieTitle,
            onValueChange = { viewModel.newMovieTitle = it },
        )


    }

}




