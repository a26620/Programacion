package com.example.loginandroid_29_09_2023.add_valoracion.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.add_obra.ContractAddObra;
import com.example.loginandroid_29_09_2023.add_obra.data.DataObras;
import com.example.loginandroid_29_09_2023.add_obra.presenter.AddObraPresenter;
import com.example.loginandroid_29_09_2023.add_valoracion.ContractAddValoracion;
import com.example.loginandroid_29_09_2023.add_valoracion.data.DataValoracion;
import com.example.loginandroid_29_09_2023.add_valoracion.presenter.AddValoracionPresenter;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.beans.Valoracion;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddValoracionModel implements ContractAddValoracion.Model {
    //private static final String IP_BASE = "192.168.104.77:8080";
    private static final String IP_BASE = "192.168.1.48:8080";
    private AddValoracionPresenter presenter;
    public AddValoracionModel(AddValoracionPresenter presenter){
        this.presenter = presenter;
    }

    @Override
    public void addValoracionAPI(int id_user, int id_obra, float puntuacion, ContractAddValoracion.Model.OnAddValoracionListener onAddValoracionListener) {
        // Crear una instancia de ApiService
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);

        // Realizar la solicitud al Servlet
        Call<DataValoracion> call = apiService.addValoracion("VALORACION.ADD", id_user, id_obra, puntuacion);
        call.enqueue(new Callback<DataValoracion>() {
            @Override
            public void onResponse(Call<DataValoracion> call, Response<DataValoracion> response) {
                if (response.isSuccessful()) {
                    DataValoracion dataValoracion = response.body();
                    ArrayList<Valoracion> listValoracion = dataValoracion.getValoracionList();

                    try {
                        onAddValoracionListener.onFinished(listValoracion);
                        Log.e("onResponse: ", "POOOOOOOO");
                    } catch (IndexOutOfBoundsException e) {
                        Log.e("No Found User", "no user exists");
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
            public void onFailure(Call<DataValoracion> call, Throwable t) {

            }
        });
    }
}
