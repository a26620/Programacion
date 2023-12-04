package com.example.loginandroid_29_09_2023.add_actuacion.presenter;

import com.example.loginandroid_29_09_2023.add_actuacion.ContractAddActuacion;
import com.example.loginandroid_29_09_2023.add_actuacion.model.AddActuacionModel;
import com.example.loginandroid_29_09_2023.beans.Obra;

public class AddActuacionPresenter implements ContractAddActuacion.Presenter, ContractAddActuacion.Model.OnAddActuacionListener  {

    private ContractAddActuacion.View view;
    private ContractAddActuacion.Model model;

    public AddActuacionPresenter(ContractAddActuacion.View view){
        this.view = view;
        model = new AddActuacionModel(this);
    }


    @Override
    public void add(Obra obra) {
        model.addActuacionAPI(obra, this);
    }

    @Override
    public void onFinished() {
        view.successLogin();
    }

    @Override
    public void onFailure(String err) {

    }
}
