package com.example.movieslisttask.model

import androidx.lifecycle.LiveData
import com.example.movieslisttask.db.AppRoomDataBase
import com.example.movieslisttask.db.MovieDao
import com.example.movieslisttask.db.entities.Movie
import com.example.movieslisttask.service.APIService

/**
 * Created by alexkorolov on 2020-01-15.
 */
class MovieRepository(private val apiService: APIService, appDB: AppRoomDataBase) {

    private var movieDao: MovieDao = appDB.movieDao()

    suspend fun fetchPopularMoviesFromAPI() {
        val movies = apiService.getPopularMovies().body()?.movies
        insertMovies(movies)
    }

    fun getPopularMovies(): LiveData<List<Movie>> {
        return movieDao.getAllMovies
    }

    fun getFavoriteMovies(): LiveData<List<Movie>> {
        return movieDao.getFavoriteMovies
    }

    private fun insertMovies(resultModel: List<Movie>?) {
        movieDao.insertMovies(resultModel)
    }

    fun updateMovie(movie: Movie) {
        if (movie.favoriteMovie == 0) {
            movie.favoriteMovie = 1
        } else {
            movie.favoriteMovie = 0
        }
        movieDao.updateMovie(movie)
    }

}