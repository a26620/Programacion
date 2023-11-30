package com.example.loginandroid_29_09_2023.list_genero.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.beans.Genero;


import com.example.loginandroid_29_09_2023.list_genero.ContractListGenero;
import com.example.loginandroid_29_09_2023.list_genero.data.DataGeneros;
import com.example.loginandroid_29_09_2023.list_genero.presenter.ListGeneroPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListGeneroModel implements ContractListGenero.Model {
    private static final String IP_BASE = "192.168.104.77:8080";
    //private static final String IP_BASE = "192.168.1.48:8080";
    private ListGeneroPresenter presenter;

    public ListGeneroModel(ListGeneroPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void listGeneroAPI(OnListGeneroListener onListGeneroListener) {
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);

        // Realizar la solicitud al Servlet
        Call<DataGeneros> call = apiService.listGeneros("GENERO.LIST");
        call.enqueue(new Callback<DataGeneros>() {

            @Override
            public void onResponse(Call<DataGeneros> call, Response<DataGeneros> response) {
                if (response.isSuccessful()) {
                    DataGeneros dataGeneros = response.body();
                    ArrayList<Genero> lstGeneros = dataGeneros.getGenerosList();

                    try {
                        onListGeneroListener.onFinished(lstGeneros);
                    } catch (IndexOutOfBoundsException e) {
                    }

                    // Actualizar la interfaz de usuario con el mensaje recibido
                } else {
                    // Manejar una respuesta no exitosa
                    // Manejar una respuesta no exitosa
                    Log.e("Response Error", "Código de estado HTTP: " + response.code());
                    try {
                        String errorBody = response.errorBody().string();
                        Log.e("Response Error", "Cuerpo de error: " + errorBody);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<DataGeneros> call, Throwable t) {

            }
        });
    }
}
