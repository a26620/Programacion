package com.example.loginandroid_29_09_2023.list_actuaciones.presenter;

import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.list_actuaciones.ContractListActuacion;
import com.example.loginandroid_29_09_2023.list_actuaciones.model.ListActuacionModel;

import java.util.ArrayList;

public class ListActuacionPresenter implements ContractListActuacion.Presenter, ContractListActuacion.Model.OnListActuacionListener {

    private ContractListActuacion.View view;
    private ContractListActuacion.Model model;

    public ListActuacionPresenter(ContractListActuacion.View view){
        this.view = view;
        model = new ListActuacionModel(this);
    }

    @Override
    public void onFinished(ArrayList<Obra> lstObra) {
        view.successlistActuacions(lstObra);
    }

    @Override
    public void onFailure(String err) {

    }

    @Override
    public void listActuacions(int id_obra) {
        model.listActuacionAPI(id_obra,this);
    }
}
