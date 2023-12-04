package com.example.loginandroid_29_09_2023.list_compra.presenter;

import com.example.loginandroid_29_09_2023.beans.Compra;
import com.example.loginandroid_29_09_2023.list_compra.ContractListCompra;
import com.example.loginandroid_29_09_2023.list_compra.model.ListCompraModel;

import java.util.ArrayList;

public class ListCompraPresenter implements ContractListCompra.Presenter, ContractListCompra.Model.OnListCompraListener {

    private ContractListCompra.View view;
    private ContractListCompra.Model model;

    public ListCompraPresenter(ContractListCompra.View view){
        this.view = view;
        model = new ListCompraModel(this);
    }

    @Override
    public void onFinished(ArrayList<Compra> lstCompra) {
        view.successlistCompras(lstCompra);
    }

    @Override
    public void onFailure(String err) {

    }

    @Override
    public void listCompras(int id_user) {
        model.listCompraAPI(id_user,this);
    }
}
