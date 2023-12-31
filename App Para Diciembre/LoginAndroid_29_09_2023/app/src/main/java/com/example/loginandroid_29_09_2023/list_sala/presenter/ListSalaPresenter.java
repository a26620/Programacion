package com.example.loginandroid_29_09_2023.list_sala.presenter;

import com.example.loginandroid_29_09_2023.add_obra.ContractAddObra;
import com.example.loginandroid_29_09_2023.beans.Sala;
import com.example.loginandroid_29_09_2023.list_sala.ContractListSala;
import com.example.loginandroid_29_09_2023.list_sala.model.ListSalaModel;

import java.util.ArrayList;

public class ListSalaPresenter implements ContractListSala.Presenter, ContractListSala.Model.OnListSalaListener{
    private ContractListSala.View view;
    private ContractListSala.Model model;

    public ListSalaPresenter(ContractListSala.View view){
        this.view = view;
        model = new ListSalaModel(this);
    }

    @Override
    public void onFinished(ArrayList<Sala> lstSala) {
        view.successLogin(lstSala);
    }

    @Override
    public void onFailure(String err) {

    }

    @Override
    public void listSala() {
        model.listSalaAPI(this);
    }
}
