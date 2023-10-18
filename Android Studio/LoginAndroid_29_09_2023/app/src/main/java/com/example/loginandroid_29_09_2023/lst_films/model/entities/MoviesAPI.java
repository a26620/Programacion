package com.example.loginandroid_29_09_2023.lst_films.model.entities;


import retrofit2.Call;
import retrofit2.http.GET;

public interface MoviesAPI {
        @GET("movie/popular?api_key=79c4fec1a2b344a92b9b800f3a43e131")
        Call<MovieResponse> getPopularMovies();
}

