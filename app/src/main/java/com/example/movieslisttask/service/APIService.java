package com.example.movieslisttask.service;

import com.example.movieslisttask.model.MoviesResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by alexkorolov on 2020-01-15.
 */
public interface APIService {

    @GET("movie/popular")
    Call<MoviesResponse> getPopularMovies(@Query("api_key") String apiKey);
}
