package com.example.movieslisttask.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieslisttask.db.AppRoomDataBase
import com.example.movieslisttask.db.MovieDao
import com.example.movieslisttask.db.entities.Movie
import com.example.movieslisttask.service.APIService
import com.example.movieslisttask.tools.Consts
import java.util.*

/**
 * Created by alexkorolov on 2020-01-15.
 */
class MovieRepository(private val apiService: APIService, private val appDB : AppRoomDataBase) {

    private var movies = ArrayList<Movie>()
    private val mutableLiveData = MutableLiveData<List<Movie>>()

    private var movieDao: MovieDao? = null

    init {
        movieDao = appDB.movieDao()
    }

//    val moviesFromAPI: Unit
//        get() {
//            val call = apiService.getPopularMovies(Consts.MOVIES_API_KEY)
//            call.enqueue(object : Callback<MoviesResponse?> {
//                override fun onResponse(call: Call<MoviesResponse?>, response: Response<MoviesResponse?>) {
//                    val movieResponse = response.body()
//                    if (movieResponse != null && movieResponse.movies != null) {
//                        movies = movieResponse.movies as ArrayList<Movie>
//                        mutableLiveData.setValue(movies)
////                        val dbRepository = MovieDBRepository(application)
////                        dbRepository.insertMovies(movies)
//
//                        insertMovies(movies)
//                    }
//                }
//
//                override fun onFailure(call: Call<MoviesResponse?>, t: Throwable) {}
//            })
//        }

    suspend fun fetchMoviewFromAPI(){
        val movies = apiService.getPopularMovies().body()?.movies
        insertMovies(movies)
    }

    fun getMoviesFromAPI() : LiveData<List<Movie>> {
        return movieDao?.allMovies!!
    }

    fun getFavoriteMovies() : LiveData<List<Movie>>{
        return movieDao!!.favoriteMovies
    }

//    val allMovies: LiveData<List<Movie?>?>?
//        get() = movieDao!!.allMovies
//
//    val allFavoriteMovies: LiveData<List<Movie?>?>?
//        get() = movieDao!!.favoriteMovies

    fun insertMovies(resultModel: List<Movie>?) {
        movieDao!!.insertMovies(resultModel)
    }

    fun updateMovie(movie: Movie) {
        if (movie.favoriteMovie == 0) {
            movie.favoriteMovie = 1
        }
        else{
            movie.favoriteMovie = 0
        }
        movieDao!!.update(movie)
    }

}