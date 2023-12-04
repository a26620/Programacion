package com.example.loginandroid_29_09_2023.add_compra.presenter;

import com.example.loginandroid_29_09_2023.add_compra.ContractAddCompra;
import com.example.loginandroid_29_09_2023.add_compra.model.AddCompraModel;
import com.example.loginandroid_29_09_2023.beans.Compra;

public class AddCompraPresenter implements ContractAddCompra.Presenter, ContractAddCompra.Model.OnAddCompraListener  {

    private ContractAddCompra.View view;
    private ContractAddCompra.Model model;

    public AddCompraPresenter(ContractAddCompra.View view){
        this.view = view;
        model = new AddCompraModel(this);
    }


    @Override
    public void add(Compra compra) {
        model.addCompraAPI(compra, this);
    }

    @Override
    public void onFinished() {
        view.successLogin();
    }

    @Override
    public void onFailure(String err) {

    }
}
