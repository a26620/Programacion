package com.example.loginandroid_29_09_2023.list_compra.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.adaptadores.listaAdminObra;
import com.example.loginandroid_29_09_2023.adaptadores.listaComprasAdapter;
import com.example.loginandroid_29_09_2023.add_compra.view.AddCompra;
import com.example.loginandroid_29_09_2023.add_valoracion.ContractAddValoracion;
import com.example.loginandroid_29_09_2023.add_valoracion.presenter.AddValoracionPresenter;
import com.example.loginandroid_29_09_2023.beans.Compra;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.beans.Valoracion;
import com.example.loginandroid_29_09_2023.ficha_descriptiva.ContractFichaDescriptiva;
import com.example.loginandroid_29_09_2023.ficha_descriptiva.presenter.FichaDescriptivaPresenter;
import com.example.loginandroid_29_09_2023.list_compra.ContractListCompra;
import com.example.loginandroid_29_09_2023.list_compra.presenter.ListCompraPresenter;

import java.util.ArrayList;


public class ListCompra extends AppCompatActivity implements ContractListCompra.View{

    SharedPreferences sharedPreferencesUserCFG;
    private RecyclerView listCompras;

    private ListCompraPresenter listCompraPresenter =
            new ListCompraPresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historialcompras);
        initComponents();
    }

    private void initComponents(){
        sharedPreferencesUserCFG = getSharedPreferences("com.MyApp.USER_CFG", Context.MODE_PRIVATE);
        int id_user = sharedPreferencesUserCFG.getInt("id_user", 0);
        listCompras = findViewById(R.id.listCompras);
        listCompraPresenter.listCompras(id_user);
    }

    @Override
    public void successlistCompras(ArrayList<Compra> lstCompra) {
        listaComprasAdapter adapterLista = new listaComprasAdapter(lstCompra);
        listCompras.setAdapter(adapterLista);
        listCompras.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void failureLogin(String err) {

    }
}