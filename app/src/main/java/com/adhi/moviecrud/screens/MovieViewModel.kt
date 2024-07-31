package com.adhi.moviecrud.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adhi.moviecrud.model.Movie
import com.adhi.moviecrud.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val repository: MovieRepository) : ViewModel() {
    private val _movieList = MutableStateFlow<List<Movie>>(emptyList())

    val movieList: StateFlow<List<Movie>> = _movieList

    var newMovieTitle by mutableStateOf("")


    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllMovies().distinctUntilChanged().collect() { listOfMovies ->
                if (listOfMovies.isEmpty()) {
                    Log.d("Empty", "Empty List")
                } else {
                    _movieList.value = listOfMovies
                }
            }
        }
    }

    fun addMovie() {
        viewModelScope.launch {
            if (newMovieTitle.isNotBlank()) {
                repository.insertMovie(Movie(title = newMovieTitle))
                newMovieTitle = ""
            }
        }
    }

    fun getMovie(id: Int): Movie? {
        return movieList.value.find { it.id == id }
    }

    fun updateMovie(movie: Movie) {
        viewModelScope.launch {
            repository.updateMovie(movie)
        }
    }

    fun deleteMovie(movie: Movie) {
        viewModelScope.launch {
            repository.deleteMovie(movie)
        }
    }
}