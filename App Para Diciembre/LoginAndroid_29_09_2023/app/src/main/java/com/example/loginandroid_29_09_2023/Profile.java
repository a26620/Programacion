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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.loginandroid_29_09_2023.adaptadores.listaBestRatingObra;
import com.example.loginandroid_29_09_2023.adaptadores.listaFilterObra;
import com.example.loginandroid_29_09_2023.adaptadores.listaMostSellObra;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.list_compra.view.ListCompra;
import com.example.loginandroid_29_09_2023.list_obra_best_rating.ContractListObraBestRating;
import com.example.loginandroid_29_09_2023.list_obra_best_rating.presenter.ListObraBestRatingPresenter;
import com.example.loginandroid_29_09_2023.list_obra_filter.ContractListObraFilter;
import com.example.loginandroid_29_09_2023.list_obra_filter.presenter.ListObraFilterPresenter;
import com.example.loginandroid_29_09_2023.lista_obra_most_sell.ContractListObraMostSell;
import com.example.loginandroid_29_09_2023.lista_obra_most_sell.presenter.ListObraMostSellPresenter;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;

import java.util.ArrayList;

public class Profile extends AppCompatActivity{


    SharedPreferences sharedPreferencesUserCFG;



    private Button btnLogOut;
    private ImageButton homebtn;
    private ImageButton communbtn;
    private ImageButton profilebtn;
    private Button btnHistorialCompras;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initComponents();
    }

    private void initComponents() {
        sharedPreferencesUserCFG = getSharedPreferences("com.MyApp.USER_CFG", Context.MODE_PRIVATE);
        btnLogOut = findViewById(R.id.btnLogOut);
        homebtn = findViewById(R.id.homebtn);
        communbtn = findViewById(R.id.communbtn);
        profilebtn = findViewById(R.id.profilebtn);
        btnHistorialCompras = findViewById(R.id.btnHistorialCompras);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferencesUserCFG.edit();
                editor.remove("isLoggedIn");
                editor.remove("username");
                editor.remove("id_user");
                editor.apply();
                Intent mainIntent = new Intent(Profile.this,
                        LoginUserM.class);
                startActivity(mainIntent);
            }
        });

        btnHistorialCompras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Profile.this,
                        ListCompra.class);
                startActivity(mainIntent);
            }
        });

        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Profile.this,
                        Home.class);
                startActivity(mainIntent);
            }
        });

        communbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Profile.this,
                        OtherObra.class);
                startActivity(mainIntent);
            }
        });

    }
}