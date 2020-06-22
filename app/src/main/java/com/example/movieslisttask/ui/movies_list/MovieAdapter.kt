package com.example.movieslisttask.ui.movies_list


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieslisttask.R
import com.example.movieslisttask.databinding.MovieListItemBinding
import com.example.movieslisttask.db.entities.Movie
import java.util.ArrayList

/**
 * Created by alexkorolov on 2020-01-15.
 */
class MovieAdapter(
        private var moviesList: ArrayList<Movie>,
        private val clickActions: onMovieClicked
) : RecyclerView.Adapter<MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val movieListItemBinding : MovieListItemBinding = DataBindingUtil.inflate(inflater,
                R.layout.movie_list_item, parent, false)

        return MovieViewHolder(movieListItemBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieListItemBinding.movie = moviesList[position]
        holder.bindClicks(clickActions, moviesList[position])
    }

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun setData(newData: List<Movie>) {
// TODO implement commented code (DIFF UTILS)
//        val diffCallback = MoviesDiffCallback(moviesList, newData)
//        val diffResult = DiffUtil.calculateDiff(diffCallback)
//        moviesList.clear()
//        moviesList.addAll(newData)
//        diffResult.dispatchUpdatesTo(this)
        moviesList = newData as ArrayList<Movie>
        notifyDataSetChanged()
    }

    interface onMovieClicked {
        fun addToFavorite(movie: Movie)
        fun openFullMovie(movie: Movie, image: ImageView)
    }
}