package com.example.loginandroid_29_09_2023.list_sala.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.add_obra.ContractAddObra;
import com.example.loginandroid_29_09_2023.add_obra.data.DataObras;
import com.example.loginandroid_29_09_2023.add_obra.presenter.AddObraPresenter;
import com.example.loginandroid_29_09_2023.beans.Sala;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.list_sala.ContractListSala;
import com.example.loginandroid_29_09_2023.list_sala.data.DataSalas;
import com.example.loginandroid_29_09_2023.list_sala.presenter.ListSalaPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListSalaModel implements ContractListSala.Model{

    private static final String IP_BASE = "192.168.104.77:8080";
    //private static final String IP_BASE = "192.168.1.48:8080";
    private ListSalaPresenter presenter;
    public ListSalaModel(ListSalaPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void listSalaAPI(OnListSalaListener OnListSalaListener) {
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);

        // Realizar la solicitud al Servlet
        Call<DataSalas> call = apiService.getDataSala ("SALA.LIST");
        call.enqueue(new Callback<DataSalas>() {
            @Override
            public void onResponse(Call<DataSalas> call, Response<DataSalas> response) {
                if (response.isSuccessful()) {
                    // Procesar la respuesta aquí
                    DataSalas dataSalas = response.body();

                    ArrayList<Sala> lstSala = dataSalas.getSalasListList();

                    try {
                        OnListSalaListener.onFinished(lstSala);
                    }catch(IndexOutOfBoundsException e){
                        Log.e("No Found User","no user exists");
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
            public void onFailure(Call<DataSalas> call, Throwable t) {

            }
        });
    }
}
