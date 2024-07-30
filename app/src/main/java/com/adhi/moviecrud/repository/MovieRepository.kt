package com.adhi.moviecrud.repository

import com.adhi.moviecrud.data.MovieDao
import com.adhi.moviecrud.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieRepository @Inject constructor(private val movieDao: MovieDao) {
    fun getAllMovies(): Flow<List<Movie>> =
        movieDao.getAllMovies().flowOn(Dispatchers.IO).conflate()

    suspend fun insertMovie(movie: Movie) = movieDao.insertMovie(movie)

    suspend fun updateMovie(movie: Movie) = movieDao.updateMovie(movie)

    suspend fun deleteMovie(movie: Movie) = movieDao.deleteMovie(movie)


}