package com.example.loginandroid_29_09_2023.list_obra.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.adaptadores.listaAdminObra;
import com.example.loginandroid_29_09_2023.adaptadores.listaAdminSala;
import com.example.loginandroid_29_09_2023.add_obra.ContractAddObra;
import com.example.loginandroid_29_09_2023.admin.view.AdminHome;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.list_obra.ContractListObra;
import com.example.loginandroid_29_09_2023.list_obra.presenter.ListObraPresenter;
import com.example.loginandroid_29_09_2023.list_sala.ContractListSala;
import com.example.loginandroid_29_09_2023.list_sala.presenter.ListSalaPresenter;
import com.example.loginandroid_29_09_2023.list_sala.view.ListSala;

import java.util.ArrayList;

public class ListObra extends AppCompatActivity implements ContractListObra.View{


    private ListObraPresenter presenter =
            new ListObraPresenter(this);

    private RecyclerView listaObrasAdmin;

    private Button AOvolverAH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_obra);
        initComponents();
    }

    private void initComponents(){
        Intent intent = getIntent(); // Obtiene el Intent que inició esta actividad
        int id = intent.getIntExtra("id", -1); // -1 es un valor predeterminado si no se encuentra el "id"
        presenter.listObra(id);
        listaObrasAdmin = findViewById(R.id.listaObrasAdmin);
        AOvolverAH = findViewById(R.id.AOvolverAH);
        AOvolverAH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(ListObra.this,
                        ListSala.class);
                startActivity(mainIntent);
            }
        });
    }


    @Override
    public void successlistObras(ArrayList<Obra> lstObra) {
        listaAdminObra adapterLista = new listaAdminObra(lstObra);
        listaObrasAdmin.setAdapter(adapterLista);
        listaObrasAdmin.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void failureLogin(String err) {

    }
}