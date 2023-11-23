package com.example.loginandroid_29_09_2023.ficha_descriptiva;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.add_valoracion.ContractAddValoracion;
import com.example.loginandroid_29_09_2023.add_valoracion.presenter.AddValoracionPresenter;
import com.example.loginandroid_29_09_2023.beans.Valoracion;


import java.util.ArrayList;


public class FichaDescriptiva extends AppCompatActivity implements ContractAddValoracion.View {

    SharedPreferences sharedPreferencesUserCFG;

    private AddValoracionPresenter presenter =
            new AddValoracionPresenter(this);

    private TextView txtTitulo;
    private TextView txtDescripcion;
    private TextView txtPrecio; 
    private TextView txtValoracionMedia;
    private TextView txtEdadRecomendada;
    private ImageView estrella1;
    private ImageView estrella2;
    private ImageView estrella3;
    private ImageView estrella4;
    private ImageView estrella5;
    private int valoracionUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_descriptiva);
        initComponents();
    }

    private void initComponents(){
        sharedPreferencesUserCFG = getSharedPreferences("com.MyApp.USER_CFG", Context.MODE_PRIVATE);
        int id_user = sharedPreferencesUserCFG.getInt("id_user", 0);
        Intent intent = getIntent();
        String titulo = intent.getStringExtra("titulo");
        String descripcion = intent.getStringExtra("descripcion");
        String precio = String.valueOf(intent.getFloatExtra("precio", 0.0f));
        int valoracionMedia = intent.getIntExtra("valoracionMedia", 0);
        int edadRecomendada = intent.getIntExtra("edadRecomendada",0);
        int id_obra = intent.getIntExtra("id_obra",0);

        txtTitulo = findViewById(R.id.txtTitulo);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtPrecio = findViewById(R.id.txtPrecio);
        txtValoracionMedia = findViewById(R.id.txtValoracionMedia);
        txtEdadRecomendada = findViewById(R.id.txtEdadRecomendada);


        txtTitulo.setText(titulo);
        txtDescripcion.setText(descripcion);
        txtPrecio.setText(precio +" €");
        txtValoracionMedia.setText(String.valueOf(valoracionMedia) + "/5");
        txtEdadRecomendada.setText(String.valueOf(edadRecomendada));

        estrella1 = findViewById(R.id.estrella1);
        estrella2 = findViewById(R.id.estrella2);
        estrella3 = findViewById(R.id.estrella3);
        estrella4 = findViewById(R.id.estrella4);
        estrella5 = findViewById(R.id.estrella5);

        

        estrella1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                estrella1.setBackgroundResource(R.drawable.fav);
                valoracionUser = 1;
                presenter.addValoracion(id_user,id_obra,valoracionUser);
            }
        });
        estrella2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                estrella1.setBackgroundResource(R.drawable.fav);
                estrella2.setBackgroundResource(R.drawable.fav);
                valoracionUser = 2;
                presenter.addValoracion(id_user,id_obra,valoracionUser);
            }
        });
        estrella3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                estrella1.setBackgroundResource(R.drawable.fav);
                estrella2.setBackgroundResource(R.drawable.fav);
                estrella3.setBackgroundResource(R.drawable.fav);
                valoracionUser = 3;
                presenter.addValoracion(id_user,id_obra,valoracionUser);
            }
        });
        estrella4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                estrella1.setBackgroundResource(R.drawable.fav);
                estrella2.setBackgroundResource(R.drawable.fav);
                estrella3.setBackgroundResource(R.drawable.fav);
                estrella4.setBackgroundResource(R.drawable.fav);
                valoracionUser = 4;
                presenter.addValoracion(id_user,id_obra,valoracionUser);
            }
        });
        estrella5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                estrella1.setBackgroundResource(R.drawable.fav);
                estrella2.setBackgroundResource(R.drawable.fav);
                estrella3.setBackgroundResource(R.drawable.fav);
                estrella4.setBackgroundResource(R.drawable.fav);
                estrella5.setBackgroundResource(R.drawable.fav);
                valoracionUser = 5;
                presenter.addValoracion(id_user,id_obra,valoracionUser);
            }
        });


    }

    @Override
    public void successAddValoracions(ArrayList<Valoracion> lstValoracion) {

    }

    @Override
    public void failureLogin(String err) {

    }
}