package com.example.movieslisttask.ui.movies_list

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.util.Pair
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.movieslisttask.R
import com.example.movieslisttask.db.entities.Movie
import com.example.movieslisttask.tools.Consts
import com.example.movieslisttask.ui.activities.MovieInfoActivity
import kotlinx.android.synthetic.main.fragment_movies.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.ArrayList


/**
 * Created by alexkorolov on 2020-01-17.
 */
class MoviesFragment : Fragment(R.layout.fragment_movies), MovieAdapter.onMovieClicked {

    private val moviesViewModel: MoviesViewModel by viewModel()
    private var isFavoritesFrag = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isFavoritesFrag = arguments?.getBoolean(Consts.SHOW_FAVORITES) ?: false
        getMovies()
    }

    private fun getMovies() {
        moviesViewModel.getMovies(isFavoritesFrag).observe(viewLifecycleOwner, Observer {
            initMoviesList(it)
        })
    }

    private var movieAdapter : MovieAdapter ? = null

    private fun initMoviesList(moviesData: List<Movie>) {
        if (movieAdapter == null) {
            println("ALEX_TAG - MoviesFragment->new adapter")
            movieAdapter = MovieAdapter(moviesData as ArrayList<Movie>, this)
            moviesList.adapter = movieAdapter
        }
        else {
            println("ALEX_TAG - MoviesFragment->update adapter")
            movieAdapter!!.setData(moviesData)
        }
    }

    companion object {
        fun newInstance(favorites: Boolean) = MoviesFragment().apply {
            arguments = Bundle().apply {
                putBoolean(Consts.SHOW_FAVORITES, favorites)
            }
        }
    }

    override fun addToFavorite(movie: Movie) {
        moviesViewModel.handleFavoriteMovie(movie)
    }

    override fun openFullMovie(movie: Movie, image: ImageView) {
        val intent = Intent(activity, MovieInfoActivity::class.java)
        intent.putExtra("movie", movie)

        val imagePair = Pair<View, String>(image, "image_transition")
        val options = ActivityOptions.makeSceneTransitionAnimation(context as Activity?, imagePair)

        startActivity(intent, options.toBundle())
    }
}