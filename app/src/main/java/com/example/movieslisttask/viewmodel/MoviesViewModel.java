package com.example.movieslisttask.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movieslisttask.model.Movie;
import com.example.movieslisttask.model.MovieDBRepository;
import com.example.movieslisttask.model.MovieRepository;

import java.util.List;

/**
 * Created by alexkorolov on 2020-01-17.
 */
public class MoviesViewModel extends AndroidViewModel {

    private MovieDBRepository dbRepository;
    private MovieRepository movieRepository;

    public MoviesViewModel(Application application) {
        super(application);
        dbRepository = new MovieDBRepository(application);
        movieRepository = new MovieRepository(application);
    }

    public LiveData<List<Movie>> getallMovies() {
        movieRepository.getMoviesFromAPI();
        return dbRepository.getAllMovies();
    }

    public LiveData<List<Movie>> getAllFavorites() {
        return dbRepository.getAllFavoriteMovies();
    }
}
