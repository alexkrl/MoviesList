package com.example.movieslisttask.ui.movies_list


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.movieslisttask.R
import com.example.movieslisttask.databinding.MovieListItemBinding
import com.example.movieslisttask.db.entities.Movie
import java.util.*

/**
 * Created by alexkorolov on 2020-01-15.
 */
class MoviesAdapter(
        private var moviesList: List<Movie>,
        private val clickActions: OnMovieClicked
) : RecyclerView.Adapter<MovieViewHolder>() {

    init {
        setHasStableIds(true) // TODO DIG DEEPER
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val movieListItemBinding: MovieListItemBinding = DataBindingUtil.inflate(inflater,
                R.layout.movie_list_item, parent, false)

        return MovieViewHolder(movieListItemBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieListItemBinding.movie = moviesList[position]
        holder.bindClicks(clickActions, moviesList[position])
    }

    override fun getItemId(position: Int) = position.toLong()

    override fun getItemCount() = moviesList.size


    fun setData(newData: List<Movie>) {
        moviesList = newData as ArrayList<Movie>
        notifyDataSetChanged()
    }

    interface OnMovieClicked {
        fun addToFavorite(movie: Movie)
        fun openFullMovie(movie: Movie, image: ImageView)
    }
}