package com.example.loginandroid_29_09_2023.list_obra_filter.presenter;

import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.list_obra_filter.ContractListObraFilter;
import com.example.loginandroid_29_09_2023.list_obra_filter.model.ListObraFilterModel;


import java.util.ArrayList;

public class ListObraFilterPresenter implements ContractListObraFilter.Presenter,ContractListObraFilter.Model.OnListObraFilterListener {

    private ContractListObraFilter.View view;
    private ContractListObraFilter.Model model;

    public ListObraFilterPresenter(ContractListObraFilter.View view){
        this.view = view;
        model = new ListObraFilterModel(this);
    }

    @Override
    public void onFinished(ArrayList<Obra> lstObra) {
        view.successlistObrasFilter(lstObra);
    }

    @Override
    public void onFailure(String err) {

    }
    @Override
    public void listObraFilter(ArrayList<Integer> id_genero,ArrayList<String> fechaActuacion,int edadRecomendada) {
        model.listObraFilterAPI(id_genero, fechaActuacion, edadRecomendada,this);
    }
}
