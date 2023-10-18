package com.example.loginandroid_29_09_2023.lst_films.model.entities;

import java.util.List;

public class MovieResponse {
    private List<Movie> results;

    public List<Movie> getResults() {
        return results;
    }

    public void setResults(List<Movie> results) {
        this.results = results;
    }
}
