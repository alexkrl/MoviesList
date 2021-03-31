package com.example.movieslisttask.ui.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.movieslisttask.databinding.ActivityMovieInfoBinding
import com.example.movieslisttask.db.entities.Movie

/**
 * Created by alexkorolov on 2020-01-17.
 */
class MovieInfoActivity : AppCompatActivity() {

    lateinit var binding: ActivityMovieInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("TAG", "onCreate: ")
        binding = ActivityMovieInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (intent.hasExtra("movie")) {
            val movie: Movie = intent.getParcelableExtra("movie")
            binding.movie = movie
            supportActionBar?.title = movie.title
        }
    }
}