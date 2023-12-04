package com.example.loginandroid_29_09_2023.add_actuacion.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.add_actuacion.ContractAddActuacion;
import com.example.loginandroid_29_09_2023.add_actuacion.presenter.AddActuacionPresenter;
import com.example.loginandroid_29_09_2023.add_obra.data.DataObras;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActuacionModel implements ContractAddActuacion.Model {
    //private static final String IP_BASE = "192.168.104.77:8080";
    private static final String IP_BASE = "192.168.1.48:8080";
    private AddActuacionPresenter presenter;
    public AddActuacionModel(AddActuacionPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void addActuacionAPI(Obra obra, OnAddActuacionListener onAddActuacionListener) {
        // Crear una instancia de ApiService
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);

        // Realizar la solicitud al Servlet
        Call<DataObras> call = apiService.addActuacion ("COMPRA.ADD",obra.getId_obra(),obra.getId_sala(),obra.getFechaActuacion(),obra.getHoraActuacion());
        call.enqueue(new Callback<DataObras>(){
            @Override
            public void onResponse(Call<DataObras> call, Response<DataObras> response) {
                if (response.isSuccessful()) {
                    DataObras dataActuacions = response.body();
                    try {
                        onAddActuacionListener.onFinished();
                        Log.e("onResponse: ","POOOOOOOO" );
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
            public void onFailure(Call<DataObras> call, Throwable t) {

            }
        });
    }
}


