package com.example.loginandroid_29_09_2023.login_user.model;

import android.util.Log;

import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.login_user.ContractLoginUser;
import com.example.loginandroid_29_09_2023.login_user.data.DataUsers;
import com.example.loginandroid_29_09_2023.login_user.presenter.LoginUserPresenter;
import com.example.loginandroid_29_09_2023.utils.ApiService;
import com.example.loginandroid_29_09_2023.utils.RetrofitCliente;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginUserModel implements ContractLoginUser.Model {
    //private static final String IP_BASE = "192.168.104.77:8080";
    private static final String IP_BASE = "192.168.1.48:8080";
    private LoginUserPresenter presenter;
    public LoginUserModel(LoginUserPresenter presenter){
        this.presenter = presenter;
    }


    @Override
    public void loginAPI(User user, final OnLoginUserListener onLoginUserListener) {
        // Crear una instancia de ApiService
        ApiService apiService = RetrofitCliente.getClient("http://" + IP_BASE + "/untitled/").
                create(ApiService.class);

        // Realizar la solicitud al Servlet
        Call<DataUsers> call = apiService.loginUser ("USER.LOGIN",user.getUsername(), user.getPass());
        call.enqueue(new Callback<DataUsers>() {

            @Override
            public void onResponse(Call<DataUsers> call, Response<DataUsers> response) {
                if (response.isSuccessful()) {
                    // Procesar la respuesta aquí
                    DataUsers dataUsers = response.body();

                    //String message = myData.getMessage();

                    ArrayList<User> lstUsers = dataUsers.getUsersList();

                    try {
                        onLoginUserListener.onFinished(lstUsers.get(0));
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
            public void onFailure(Call<DataUsers> call, Throwable t) {

            }

        });
    }
    }

