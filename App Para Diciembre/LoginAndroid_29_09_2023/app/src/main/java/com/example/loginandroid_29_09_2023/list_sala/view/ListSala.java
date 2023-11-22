package com.example.loginandroid_29_09_2023.list_sala.view;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.adaptadores.listaAdminSala;
import com.example.loginandroid_29_09_2023.adaptadores.listaAdminObra;
import com.example.loginandroid_29_09_2023.add_obra.ContractAddObra;
import com.example.loginandroid_29_09_2023.add_obra.presenter.AddObraPresenter;
import com.example.loginandroid_29_09_2023.add_obra.view.AddObra;
import com.example.loginandroid_29_09_2023.admin.view.AdminHome;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.beans.Sala;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.list_obra.ContractListObra;
import com.example.loginandroid_29_09_2023.list_obra.presenter.ListObraPresenter;
import com.example.loginandroid_29_09_2023.list_obra.view.ListObra;
import com.example.loginandroid_29_09_2023.list_sala.ContractListSala;
import com.example.loginandroid_29_09_2023.list_sala.presenter.ListSalaPresenter;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;

import java.util.ArrayList;

public class ListSala extends AppCompatActivity implements ContractListSala.View{

    private ListSalaPresenter presenter =
            new ListSalaPresenter(this);

    private RecyclerView lista;

    private Button AOvolverAH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sala);
        initComponents();
    }

    private void initComponents(){
        presenter.listSala();
        lista = findViewById(R.id.lista);
        AOvolverAH = findViewById(R.id.AOvolverAH);
        AOvolverAH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ListSala.this,
                        AdminHome.class);
                startActivity(mainIntent);
            }
        });
    }

    @Override
    public void successLogin(ArrayList<Sala> listSala) {
        listaAdminSala adapterLista = new listaAdminSala(listSala);
        lista.setAdapter(adapterLista);
        lista.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void failureLogin(String err) {

    }
}