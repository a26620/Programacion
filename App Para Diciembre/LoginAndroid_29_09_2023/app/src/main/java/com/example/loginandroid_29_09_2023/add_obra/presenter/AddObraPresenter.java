package com.example.loginandroid_29_09_2023.add_obra.presenter;

import android.util.Log;

import com.example.loginandroid_29_09_2023.add_obra.ContractAddObra;
import com.example.loginandroid_29_09_2023.add_obra.model.AddObraModel;
import com.example.loginandroid_29_09_2023.beans.Obra;

public class AddObraPresenter implements ContractAddObra.Presenter, ContractAddObra.Model.OnAddObraListener  {

    private ContractAddObra.View view;
    private ContractAddObra.Model model;

    public AddObraPresenter(ContractAddObra.View view){
        this.view = view;
        model = new AddObraModel(this);
    }


    @Override
    public void add(Obra obra) {
        model.addObraAPI(obra, this);
    }

    @Override
    public void onFinished() {
        view.successLogin();
    }

    @Override
    public void onFailure(String err) {

    }
}
