package com.example.loginandroid_29_09_2023.list_obra_best_rating.presenter;

import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.list_obra_best_rating.ContractListObraBestRating;
import com.example.loginandroid_29_09_2023.list_obra_best_rating.model.ListObraBestRatingModel;


import java.util.ArrayList;

public class ListObraBestRatingPresenter implements ContractListObraBestRating.Presenter,ContractListObraBestRating.Model.OnListObraBestRatingListener {

    private ContractListObraBestRating.View view;
    private ContractListObraBestRating.Model model;

    public ListObraBestRatingPresenter(ContractListObraBestRating.View view){
        this.view = view;
        model = new ListObraBestRatingModel(this);
    }

    @Override
    public void onFinished(ArrayList<Obra> lstObra) {
        view.successlistObrasBestRating(lstObra);
    }

    @Override
    public void onFailure(String err) {

    }
    @Override
    public void listObraBestRating() {
        model.listObraBestRatingAPI(this);
    }
}
