package com.example.loginandroid_29_09_2023.ficha_descriptiva.presenter;

import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.ficha_descriptiva.ContractFichaDescriptiva;
import com.example.loginandroid_29_09_2023.ficha_descriptiva.model.FichaDescriptivaModel;


import java.util.ArrayList;

public class FichaDescriptivaPresenter implements ContractFichaDescriptiva.Presenter,ContractFichaDescriptiva.Model.OnFichaDescriptivaListener {

    private ContractFichaDescriptiva.View view;
    private ContractFichaDescriptiva.Model model;

    public FichaDescriptivaPresenter(ContractFichaDescriptiva.View view){
        this.view = view;
        model = new FichaDescriptivaModel(this);
    }

    @Override
    public void onFinished(Obra obra) {
        view.successfichaDescriptiva(obra);
    }

    @Override
    public void onFailure(String err) {

    }
    @Override
    public void fichaDescriptiva(int id) {
        model.fichaDescriptivaAPI(id, this);
    }
}
