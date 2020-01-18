package com.example.movieslisttask.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Created by alexkorolov on 2020-01-17.
 */
@Dao
public interface MovieDao {

    @Query("SELECT * from movies_table ORDER BY id ASC")
    LiveData<List<Movie>> getAllMovies();

    @Query("SELECT * from movies_table WHERE isFavoiteMovie == 1 ORDER BY id ASC")
//
    LiveData<List<Movie>> getFavoriteMovies();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMovies(List<Movie> movieList);

    @Update
    void update(Movie movie);
}
