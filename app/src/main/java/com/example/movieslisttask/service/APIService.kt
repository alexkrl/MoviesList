package com.example.movieslisttask.service

import com.example.movieslisttask.service.responses.MoviesResponse
import com.example.movieslisttask.tools.Consts
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by alexkorolov on 2020-01-15.
 */
interface APIService {

    @GET("movie/popular?api_key=${Consts.MOVIES_API_KEY}")
    suspend fun getPopularMovies(): Response<MoviesResponse>

}