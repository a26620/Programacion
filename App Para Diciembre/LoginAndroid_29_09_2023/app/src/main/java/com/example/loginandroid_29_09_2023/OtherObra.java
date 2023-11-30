package com.example.loginandroid_29_09_2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.loginandroid_29_09_2023.adaptadores.listaBestRatingObra;
import com.example.loginandroid_29_09_2023.adaptadores.listaFilterObra;
import com.example.loginandroid_29_09_2023.adaptadores.listaMostSellObra;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.list_obra_best_rating.ContractListObraBestRating;
import com.example.loginandroid_29_09_2023.list_obra_best_rating.presenter.ListObraBestRatingPresenter;
import com.example.loginandroid_29_09_2023.list_obra_filter.ContractListObraFilter;
import com.example.loginandroid_29_09_2023.list_obra_filter.presenter.ListObraFilterPresenter;
import com.example.loginandroid_29_09_2023.lista_obra_most_sell.ContractListObraMostSell;
import com.example.loginandroid_29_09_2023.lista_obra_most_sell.presenter.ListObraMostSellPresenter;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;

import java.util.ArrayList;

public class OtherObra extends AppCompatActivity implements ContractListObraMostSell.View, ContractListObraBestRating.View{


    SharedPreferences sharedPreferencesUserCFG;

    private ListObraMostSellPresenter presenter =
            new ListObraMostSellPresenter(this);

    private ListObraBestRatingPresenter presenter2 =
            new ListObraBestRatingPresenter(this);


    private RecyclerView listaMostSell;
    private RecyclerView listaBestRating;

    private ImageButton homebtn;
    private ImageButton communbtn;
    private ImageButton profilebtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otherobra);
        initComponents();
    }

    private void initComponents() {
        sharedPreferencesUserCFG = getSharedPreferences("com.MyApp.USER_CFG", Context.MODE_PRIVATE);
        presenter.listObraMostSell();
        presenter2.listObraBestRating();
        listaMostSell = findViewById(R.id.listaMostSell);
        listaBestRating = findViewById(R.id.listaBestRating);
        homebtn = findViewById(R.id.homebtn);
        communbtn = findViewById(R.id.communbtn);
        profilebtn = findViewById(R.id.profilebtn);
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(OtherObra.this,
                        Home.class);
                startActivity(mainIntent);
            }
        });
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(OtherObra.this,
                        Profile.class);
                startActivity(mainIntent);
            }
        });

    }

    @Override
    public void successlistObrasMostSell(ArrayList<Obra> lstObra) {
        listaMostSellObra adapterListaMostSell = new listaMostSellObra(lstObra);
        listaMostSell.setAdapter(adapterListaMostSell);
        listaMostSell.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void failureLogin(String err) {

    }


    @Override
    public void successlistObrasBestRating(ArrayList<Obra> lstObra) {
        listaBestRatingObra adapterListaBestRating = new listaBestRatingObra(lstObra);
        listaBestRating.setAdapter(adapterListaBestRating);
        listaBestRating.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void failurelistObrasBestRating(String err) {

    }



}