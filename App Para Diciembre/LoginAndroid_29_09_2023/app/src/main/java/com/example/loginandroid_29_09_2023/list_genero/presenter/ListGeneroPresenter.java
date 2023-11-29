package com.example.loginandroid_29_09_2023.list_genero.presenter;

import android.util.Log;

import com.example.loginandroid_29_09_2023.beans.Genero;
import com.example.loginandroid_29_09_2023.list_genero.ContractListGenero;
import com.example.loginandroid_29_09_2023.list_genero.model.ListGeneroModel;


import java.util.ArrayList;

public class ListGeneroPresenter implements ContractListGenero.Presenter,ContractListGenero.Model.OnListGeneroListener {

    private ContractListGenero.View view;
    private ContractListGenero.Model model;

    public ListGeneroPresenter(ContractListGenero.View view){
        this.view = view;
        model = new ListGeneroModel(this);
    }

    @Override
    public void onFinished(ArrayList<Genero> lstGenero) {
        view.successlistGeneros(lstGenero);
    }

    @Override
    public void onFailure(String err) {

    }

    @Override
    public void listGeneros() {
        model.listGeneroAPI(this);
    }
}
