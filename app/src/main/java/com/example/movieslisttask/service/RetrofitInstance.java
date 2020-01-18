package com.example.movieslisttask.service;

import com.example.movieslisttask.tools.Consts;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alexkorolov on 2020-01-15.
 */
public class RetrofitInstance {

    private static Retrofit retrofit = null;

    public static APIService getService() {

        if (retrofit == null) {
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(Consts.BASE_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit.create(APIService.class);

    }
}
