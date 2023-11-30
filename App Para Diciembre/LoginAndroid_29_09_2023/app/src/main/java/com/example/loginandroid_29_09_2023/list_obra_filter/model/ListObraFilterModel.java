package com.example.loginandroid_29_09_2023.list_obra_filter.model;

import android.text.TextUtils;
import android.util.Log;

import com.example.loginandroid_29_09_2023.Home;
import com.example.loginandroid_29_09_2023.add_obra.data.DataObras;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.list_obra_filter.ContractListObraFilter;
import com.example.loginandroid_29_09_2023.list_obra_filter.presenter.ListObraFilterPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListObraFilterModel implements ContractListObraFilter.Model {
    private static final String IP_BASE = "192.168.104.77:8080";
    //private static final String IP_BASE = "192.168.1.48:8080";
    private ListObraFilterPresenter presenter;

    public ListObraFilterModel(ListObraFilterPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void listObraFilterAPI(ArrayList<Integer> id_genero, ArrayList<Integer> edadRecomendada,OnListObraFilterListener onListObraFilterListener) {
        // Crear una instancia de ApiService
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);

        // Realizar la solicitud al Servlet
        Log.e("ARRAYYY MODEL: ",edadRecomendada.toString());
        String idGeneroParam = TextUtils.join(",", id_genero);
        String edadRecomendadaParam = TextUtils.join(",", edadRecomendada);
        Call<DataObras> call = apiService.listObrasFilter("OBRA.LISTFILTER", idGeneroParam, edadRecomendadaParam);
        call.enqueue(new Callback<DataObras>() {
            @Override
            public void onResponse(Call<DataObras> call, Response<DataObras> response) {
                if (response.isSuccessful()) {
                    DataObras dataObras = response.body();
                    ArrayList<Obra> listObras = dataObras.getObrasList();
                    try {
                        onListObraFilterListener.onFinished(listObras);
                    } catch (IndexOutOfBoundsException e) {
                    }

                    // Actualizar la interfaz de usuario con el mensaje recibido
                } else {
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
