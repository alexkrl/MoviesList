package com.example.movieslisttask.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.movieslisttask.db.entities.Movie

/**
 * Created by alexkorolov on 2020-01-17.
 */
@Dao
interface MovieDao {

    @get:Query("SELECT * from movies_table ORDER BY id ASC")
    val getAllMovies: LiveData<List<Movie>>

    @get:Query("SELECT * from movies_table WHERE favoriteMovie == 1 ORDER BY id ASC")
    val getFavoriteMovies: LiveData<List<Movie>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertMovies(movieList: List<Movie?>?)

    @Update
    fun updateMovie(movie: Movie?)
}