package com.example.movieslisttask.view.ui.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.movieslisttask.R;
import com.example.movieslisttask.databinding.ActivityMovieInfoBinding;
import com.example.movieslisttask.model.Movie;

/**
 * Created by alexkorolov on 2020-01-17.
 */
public class MovieInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_info);
        ActivityMovieInfoBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_info);

        Intent intent = getIntent();
        if (intent.hasExtra("movie")) {
            Movie movie = getIntent().getParcelableExtra("movie");
            binding.setMovie(movie);
            getSupportActionBar().setTitle(movie.getTitle());
        }

    }
}
