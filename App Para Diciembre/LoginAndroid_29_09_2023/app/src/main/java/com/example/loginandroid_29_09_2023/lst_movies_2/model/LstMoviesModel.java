/*package com.example.loginandroid_29_09_2023.lst_movies_2.model;

import com.example.loginandroid_29_09_2023.beans.Pelicula;
import com.example.loginandroid_29_09_2023.lst_movies_2.ContractListMovies;
import com.example.loginandroid_29_09_2023.lst_movies_2.DataMovies;
import com.example.loginandroid_29_09_2023.lst_movies_2.presenter.LstMoviesPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LstMoviesModel implements ContractListMovies.Model {
    private static final String IP_BASE = "192.168.104.77:8080";
    private LstMoviesPresenter presenter;

    public LstMoviesModel(LstMoviesPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void moviesAPI(String filtro,
                          OnLstMoviesListener respuestaMovies) {

        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);
        Call<DataMovies> call = apiService.getDataMovies("MOVIE.LST");
        call.enqueue(new Callback<DataMovies>() {
            @Override
            public void onResponse(Call<DataMovies> call, Response<DataMovies> response) {
                if (response.isSuccessful()) {
                    DataMovies myData = response.body();
                    ArrayList<Pelicula> lstMovies = myData.getLstPeliculas();
                    respuestaMovies.onFinished(lstMovies);
                }
            }

            @Override
            public void onFailure(Call<DataMovies> call, Throwable t) {

            }
        });
    }
}
*/
