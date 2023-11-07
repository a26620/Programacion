package com.example.retrofitservlet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String IP_BASE = "192.168.104.77:8080";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear una instancia de ApiService
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                    create(ApiService.class);

// Realizar la solicitud al Servlet
        // Call<MyData> call = apiService.getMyData("1");
        Call<MyData> call = apiService.getMyDataMovies ("MOVIE.LIST_ALL");
        call.enqueue(new Callback<MyData>() {
            @Override
            public void onResponse(Call<MyData> call, Response<MyData> response) {
                if (response.isSuccessful()) {
                    // Procesar la respuesta aquí
                    MyData myData = response.body();

                    //String message = myData.getMessage();

                    ArrayList<User> lstUsers = myData.getLstUsers();

                    Toast.makeText(MainActivity.this, lstUsers.get(0).getUsername(), Toast.LENGTH_SHORT).show();
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
            public void onFailure(Call<MyData> call, Throwable t) {
                // Manejar errores de red o del servidor
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}