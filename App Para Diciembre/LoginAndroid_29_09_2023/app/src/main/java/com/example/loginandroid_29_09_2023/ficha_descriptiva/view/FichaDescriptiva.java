package com.example.loginandroid_29_09_2023.ficha_descriptiva.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.Rating;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.animation.core.FloatTweenSpec;

import com.example.loginandroid_29_09_2023.Home;
import com.example.loginandroid_29_09_2023.Profile;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.add_compra.view.AddCompra;
import com.example.loginandroid_29_09_2023.add_obra.view.AddObra;
import com.example.loginandroid_29_09_2023.add_valoracion.ContractAddValoracion;
import com.example.loginandroid_29_09_2023.add_valoracion.presenter.AddValoracionPresenter;
import com.example.loginandroid_29_09_2023.admin.view.AdminHome;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.beans.Valoracion;
import com.example.loginandroid_29_09_2023.ficha_descriptiva.ContractFichaDescriptiva;
import com.example.loginandroid_29_09_2023.ficha_descriptiva.presenter.FichaDescriptivaPresenter;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;


import java.util.ArrayList;


public class FichaDescriptiva extends AppCompatActivity implements ContractAddValoracion.View, ContractFichaDescriptiva.View{

    SharedPreferences sharedPreferencesUserCFG;

    private AddValoracionPresenter addValoracionPresenter =
            new AddValoracionPresenter(this);
    private FichaDescriptivaPresenter fichaDescriptivaPresenter =
            new FichaDescriptivaPresenter(this);

    private TextView txtTitulo;
    private TextView txtDescripcion;
    private TextView txtPrecio;
    private TextView txtValoracionMedia;
    private TextView txtEdadRecomendada;
    private TextView txtGenero;
    private TextView txtDuracion;
    private RatingBar ratingBar;
    private ImageButton backBtn;
    private Button btnViewComprar;
    private float valorRate;

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
        int id_obra = intent.getIntExtra("id_obra",0);
        fichaDescriptivaPresenter.fichaDescriptiva(id_obra);
        txtTitulo = findViewById(R.id.txtTitulo);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        txtPrecio = findViewById(R.id.txtPrecio);

        txtValoracionMedia = findViewById(R.id.txtValoracionMedia);
        txtEdadRecomendada = findViewById(R.id.txtEdadRecomendada);
        txtGenero = findViewById(R.id.txtGenero);
        txtDuracion = findViewById(R.id.txtDuracion);
        ratingBar = findViewById(R.id.ratingBar);
        valorRate = ratingBar.getRating();
        backBtn = findViewById(R.id.backBtn);
        btnViewComprar = findViewById(R.id.btnViewComprar);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ratingBar.setOnRatingBarChangeListener((ratingBar, valorRate, fromUser) ->{
            if (fromUser) {
                addValoracionPresenter.addValoracion(id_user,id_obra,valorRate);
                Log.e("RATEEEEEEEEEE:", String.valueOf(valorRate));
            }
        });
        btnViewComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(FichaDescriptiva.this,
                        AddCompra.class);
                mainIntent.putExtra("id_obra", id_obra);
                startActivity(mainIntent);
            }
        });
    }

    @Override
    public void successAddValoracions(ArrayList<Valoracion> lstValoracion) {

    }

    @Override
    public void failureLogin(String err) {

    }


    @Override
    public void successfichaDescriptiva(Obra obra) {
        txtTitulo.setText(obra.getTitulo());
        txtDescripcion.setText(obra.getDescripcion());
        txtPrecio.setText(obra.getPrecio() +" €");
        txtValoracionMedia.setText(String.valueOf(obra.getValoracionMedia()) + "/5");
        txtEdadRecomendada.setText("+"+String.valueOf(obra.getEdadRecomendada()));
        txtGenero.setText(obra.getGenero());
        txtDuracion.setText("("+String.valueOf(obra.getDuracion()) + "min )");
    }

    @Override
    public void failurefichaDescriptiva(String err) {

    }
}