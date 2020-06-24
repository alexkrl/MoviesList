package com.example.movieslisttask.ui.movies_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieslisttask.db.entities.Movie
import com.example.movieslisttask.model.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by alexkorolov on 2020-01-17.
 */
class MoviesViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    fun getMovies(isFavorite: Boolean): LiveData<List<Movie>> {
        return if (isFavorite) {
            movieRepository.getFavoriteMovies()
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                movieRepository.fetchPopularMoviesFromAPI()
            }
            movieRepository.getPopularMovies()
        }
    }

    fun handleFavoriteMovie(movie: Movie) {
        viewModelScope.launch(Dispatchers.IO) {
            movieRepository.updateMovie(movie)
        }
    }
}