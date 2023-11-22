package com.example.loginandroid_29_09_2023.lista_obra_most_sell.presenter;

import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.lista_obra_most_sell.ContractListObraMostSell;
import com.example.loginandroid_29_09_2023.lista_obra_most_sell.model.ListObraMostSellModel;

import java.util.ArrayList;

public class ListObraMostSellPresenter implements ContractListObraMostSell.Presenter,ContractListObraMostSell.Model.OnListObraMostSellListener {

    private ContractListObraMostSell.View view;
    private ContractListObraMostSell.Model model;

    public ListObraMostSellPresenter(ContractListObraMostSell.View view){
        this.view = view;
        model = new ListObraMostSellModel(this);
    }

    @Override
    public void onFinished(ArrayList<Obra> lstObra) {
        view.successlistObrasMostSell(lstObra);
    }

    @Override
    public void onFailure(String err) {

    }
    @Override
    public void listObraMostSell() {
        model.listObraMostSellAPI(this);
    }
}
