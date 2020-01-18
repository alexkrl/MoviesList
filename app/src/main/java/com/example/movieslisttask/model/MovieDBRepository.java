package com.example.movieslisttask.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.movieslisttask.db.AppRoomDataBase;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by alexkorolov on 2020-01-17.
 */
public class MovieDBRepository {

    private MovieDao movieDao;

    public MovieDBRepository(Application application) {
        AppRoomDataBase db = AppRoomDataBase.getDatabase(application);
        movieDao = db.movieDao();
    }

    public LiveData<List<Movie>> getAllMovies() {
        return movieDao.getAllMovies();
    }

    public LiveData<List<Movie>> getAllFavoriteMovies() {
        return movieDao.getFavoriteMovies();
    }

    void insertMovies(List<Movie> resultModel) {
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(() -> movieDao.insertMovies(resultModel));
    }

    public void updateMovie(Movie movie) {
        Executor myExecutor = Executors.newSingleThreadExecutor();
        myExecutor.execute(() -> movieDao.update(movie));
    }
}
