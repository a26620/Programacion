package com.example.loginandroid_29_09_2023.lista_obra_most_sell.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.adaptadores.listaMostSellObra;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.lista_obra_most_sell.ContractListObraMostSell;
import com.example.loginandroid_29_09_2023.lista_obra_most_sell.presenter.ListObraMostSellPresenter;

import java.util.ArrayList;

public class ListObraMostSell extends AppCompatActivity implements ContractListObraMostSell.View {


    private ListObraMostSellPresenter presenter =
            new ListObraMostSellPresenter(this);

    private RecyclerView listaObrasAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_obra_most_sell);
        initComponents();
    }

    private void initComponents(){
        presenter.listObraMostSell();
        listaObrasAdmin = findViewById(R.id.listaObrasAdmin2);
    }

    @Override
    public void successlistObrasMostSell(ArrayList<Obra> lstObra) {
        listaMostSellObra adapterLista = new listaMostSellObra(lstObra);
        listaObrasAdmin.setAdapter(adapterLista);
        listaObrasAdmin.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void failureLogin(String err) {

    }
}