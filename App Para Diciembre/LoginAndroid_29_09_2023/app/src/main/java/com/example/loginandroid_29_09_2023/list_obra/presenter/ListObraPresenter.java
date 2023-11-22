package com.example.loginandroid_29_09_2023.list_obra.presenter;

import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.list_obra.ContractListObra;
import com.example.loginandroid_29_09_2023.list_obra.model.ListObraModel;


import java.util.ArrayList;

public class ListObraPresenter implements ContractListObra.Presenter,ContractListObra.Model.OnListObraListener {

    private ContractListObra.View view;
    private ContractListObra.Model model;

    public ListObraPresenter(ContractListObra.View view){
        this.view = view;
        model = new ListObraModel(this);
    }

    @Override
    public void onFinished(ArrayList<Obra> lstObra) {
        view.successlistObras(lstObra);
    }

    @Override
    public void onFailure(String err) {

    }
    @Override
    public void listObra(int id) {
        model.listObraAPI(id, this);
    }
}
