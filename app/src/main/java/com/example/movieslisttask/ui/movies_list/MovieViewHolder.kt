package com.example.movieslisttask.ui.movies_list

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieslisttask.R
import com.example.movieslisttask.db.entities.Movie
import com.example.movieslisttask.ui.activities.MainActivity
import com.example.movieslisttask.ui.activities.MovieInfoActivity

/**
 * Created by alexkorolov on 21/06/2020.
 */
class MovieViewHolder(inflater: LayoutInflater, parent: ViewGroup)
    : RecyclerView.ViewHolder(inflater.inflate(R.layout.movie_list_item, parent, false)) {

    var moviePoster : ImageView? = null
    var favoriteIndicator : ImageView? = null

    init {
        moviePoster = itemView.findViewById(R.id.movie_poster)
        favoriteIndicator = itemView.findViewById(R.id.favorite_indicator)
    }

    fun bind(movie: Movie, onItemClicked: MovieAdapter.onMovieClicked){
        val imagePath = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
        moviePoster?.let { Glide.with(itemView.context).load(imagePath).into(it) }


        favoriteIndicator?.setOnClickListener {
            onItemClicked.addToFavorite(movie)
        }

        itemView.rootView.setOnClickListener {
            moviePoster?.let { it1 -> onItemClicked.openFullMovie(movie, it1) }
        }

    }
}