package com.adhi.moviecrud.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adhi.moviecrud.R
import com.adhi.moviecrud.components.MinimalInputField
import com.adhi.moviecrud.model.Movie


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddNewMovie(
    viewModel: MovieViewModel
) {
    Column {
        TopAppBar(title = {
            Text(text = stringResource(id = R.string.app_name))
        })

        MinimalInputField(value = viewModel.newMovieTitle,
            onValueChange = { viewModel.newMovieTitle = it },
            onUpdate = { }
        )

        Button(onClick = { viewModel.addMovie()},
            enabled = viewModel.newMovieTitle.isNotBlank()) {
            Text(text = "Add movie")

        }
    }

}




