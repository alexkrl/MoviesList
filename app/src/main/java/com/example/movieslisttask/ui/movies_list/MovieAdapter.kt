package com.example.movieslisttask.ui.movies_list

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieslisttask.db.entities.Movie

/**
 * Created by alexkorolov on 2020-01-15.
 */
class MovieAdapter(
        private var moviesList: List<Movie>,
        private val clickActions: onMovieClicked
) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        println("ALEX_TAG - MovieAdapter->onCreateViewHolder")
        val inflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        println("ALEX_TAG - MovieAdapter->onBindViewHolder")
        val movie = moviesList[position]
        holder.bind(movie, clickActions)
    }

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemCount(): Int {
        return moviesList.size
    }

    interface onMovieClicked{
        fun addToFavorite(movie : Movie)
        fun openFullMovie(movie: Movie, image: ImageView)
    }
}