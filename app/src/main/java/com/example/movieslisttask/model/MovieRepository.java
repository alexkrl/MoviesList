package com.example.movieslisttask.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.movieslisttask.service.APIService;
import com.example.movieslisttask.service.RetrofitInstance;
import com.example.movieslisttask.tools.Consts;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by alexkorolov on 2020-01-15.
 */
public class MovieRepository {

    private ArrayList<Movie> movies = new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public MovieRepository(Application application) {
        this.application = application;
    }

    public void getMoviesFromAPI() {

        APIService apiService = RetrofitInstance.getService();

        Call<MoviesResponse> call = apiService.getPopularMovies(Consts.MOVIES_API_KEY);

        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                MoviesResponse movieResponse = response.body();
                if (movieResponse != null && movieResponse.getMovies() != null) {
                    movies = (ArrayList<Movie>) movieResponse.getMovies();
                    mutableLiveData.setValue(movies);

                    MovieDBRepository dbRepository = new MovieDBRepository(application);
                    dbRepository.insertMovies(movies);
                }
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {

            }
        });


//        return mutableLiveData;
    }
}
