package com.example.loginandroid_29_09_2023.add_valoracion.presenter;

import com.example.loginandroid_29_09_2023.beans.Valoracion;
import com.example.loginandroid_29_09_2023.add_valoracion.ContractAddValoracion;
import com.example.loginandroid_29_09_2023.add_valoracion.model.AddValoracionModel;


import java.util.ArrayList;

public class AddValoracionPresenter implements ContractAddValoracion.Presenter,ContractAddValoracion.Model.OnAddValoracionListener {

    private ContractAddValoracion.View view;
    private ContractAddValoracion.Model model;

    public AddValoracionPresenter(ContractAddValoracion.View view){
        this.view = view;
        model = new AddValoracionModel(this);
    }

    @Override
    public void onFinished(ArrayList<Valoracion> lstValoracion) {
        view.successAddValoracions(lstValoracion);
    }

    @Override
    public void onFailure(String err) {

    }
    @Override
    public void addValoracion(int id_user, int id_obra, int puntuacion) {
        model.addValoracionAPI(id_user,id_obra,puntuacion, this);
    }
}
