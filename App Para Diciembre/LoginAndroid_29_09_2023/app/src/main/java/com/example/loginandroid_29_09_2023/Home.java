package com.example.loginandroid_29_09_2023;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.loginandroid_29_09_2023.adaptadores.listaBestRatingObra;
import com.example.loginandroid_29_09_2023.adaptadores.listaMostSellObra;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.list_obra_best_rating.ContractListObraBestRating;
import com.example.loginandroid_29_09_2023.list_obra_best_rating.presenter.ListObraBestRatingPresenter;
import com.example.loginandroid_29_09_2023.lista_obra_most_sell.ContractListObraMostSell;
import com.example.loginandroid_29_09_2023.lista_obra_most_sell.presenter.ListObraMostSellPresenter;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements ContractListObraMostSell.View, ContractListObraBestRating.View {

    private ListObraMostSellPresenter presenter =
            new ListObraMostSellPresenter(this);

    private ListObraBestRatingPresenter presenter2 =
            new ListObraBestRatingPresenter(this);

    private RecyclerView listaMostSell;
    private RecyclerView listaBestRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initComponents();
    }

    private void initComponents(){
        presenter.listObraMostSell();
        presenter2.listObraBestRating();
        listaMostSell = findViewById(R.id.listaMostSell);
        listaBestRating = findViewById(R.id.listaBestRating);
    }

    @Override
    public void successlistObrasMostSell(ArrayList<Obra> lstObra) {
        listaMostSellObra adapterListaMostSell = new listaMostSellObra(lstObra);
        listaMostSell.setAdapter(adapterListaMostSell);
        listaMostSell.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void failureLogin(String err) {

    }


    @Override
    public void successlistObrasBestRating(ArrayList<Obra> lstObra) {
        listaBestRatingObra adapterListaBestRating = new listaBestRatingObra(lstObra);
        listaBestRating.setAdapter(adapterListaBestRating);
        listaBestRating.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void failurelistObrasBestRating(String err) {

    }
}