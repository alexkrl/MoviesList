package com.example.movieslisttask.ui.movies_list

import androidx.recyclerview.widget.RecyclerView
import com.example.movieslisttask.databinding.MovieListItemBinding
import com.example.movieslisttask.db.entities.Movie

/**
 * Created by alexkorolov on 21/06/2020.
 */
class MovieViewHolder(val movieListItemBinding: MovieListItemBinding) : RecyclerView.ViewHolder(movieListItemBinding.root) {

    fun bindClicks(clickActions: MoviesAdapter.OnMovieClicked, movie: Movie) {
        movieListItemBinding.favoriteIndicator.setOnClickListener {
            clickActions.addToFavorite(movie)
        }

        movieListItemBinding.root.setOnClickListener {
            clickActions.openFullMovie(movie, movieListItemBinding.moviePoster)
        }
    }
}