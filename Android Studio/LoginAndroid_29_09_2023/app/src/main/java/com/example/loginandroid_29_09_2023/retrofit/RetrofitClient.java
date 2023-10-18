package com.example.loginandroid_29_09_2023.retrofit;

import com.example.loginandroid_29_09_2023.lst_films.model.entities.MoviesAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    private static MoviesAPI instance;

    public static MoviesAPI getInstance() {
        if (instance == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            instance = retrofit.create(MoviesAPI.class);
        }

        return instance;
    }

}
