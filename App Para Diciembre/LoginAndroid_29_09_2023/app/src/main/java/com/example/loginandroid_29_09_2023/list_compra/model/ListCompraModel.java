package com.example.loginandroid_29_09_2023.list_compra.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.add_compra.data.DataCompras;
import com.example.loginandroid_29_09_2023.beans.Compra;
import com.example.loginandroid_29_09_2023.list_compra.ContractListCompra;
import com.example.loginandroid_29_09_2023.list_compra.presenter.ListCompraPresenter;

import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListCompraModel implements ContractListCompra.Model {
    private static final String IP_BASE = "192.168.104.77:8080";
    //private static final String IP_BASE = "192.168.1.48:8080";
    private ListCompraPresenter presenter;

    public ListCompraModel(ListCompraPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void listCompraAPI(int id_user, OnListCompraListener onListCompraListener) {
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);

        // Realizar la solicitud al Servlet
        Call<DataCompras> call = apiService.listCompras("COMPRA.LIST", id_user);
        call.enqueue(new Callback<DataCompras>() {

            @Override
            public void onResponse(Call<DataCompras> call, Response<DataCompras> response) {
                if (response.isSuccessful()) {
                    DataCompras dataCompras = response.body();
                    ArrayList<Compra> lstCompras = dataCompras.getComprasList();

                    try {
                        onListCompraListener.onFinished(lstCompras);
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
            public void onFailure(Call<DataCompras> call, Throwable t) {

            }
        });
    }
}
