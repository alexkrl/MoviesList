package com.example.movieslisttask.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.movieslisttask.R
import com.example.movieslisttask.databinding.ActivityMovieInfoBinding
import com.example.movieslisttask.db.entities.Movie

/**
 * Created by alexkorolov on 2020-01-17.
 */
class MovieInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_info)

        val binding: ActivityMovieInfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_info)
        if (intent.hasExtra("movie")) {
            val movie: Movie = intent.getParcelableExtra("movie")
            binding.movie = movie
            supportActionBar?.title = movie.title
        }
    }
}