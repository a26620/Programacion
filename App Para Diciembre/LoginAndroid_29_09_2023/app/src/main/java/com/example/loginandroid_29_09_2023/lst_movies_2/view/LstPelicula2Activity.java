package com.example.loginandroid_29_09_2023.lst_movies_2.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Pelicula;
import com.example.loginandroid_29_09_2023.lstMov.ContractListMovies;
import com.example.loginandroid_29_09_2023.lstMov.presenter.LstMoviesPresenter;

import java.util.ArrayList;

public class LstPelicula2Activity extends AppCompatActivity
                                    implements ContractListMovies.View
{

    private LstMoviesPresenter lstMoviesPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_pelicula2);

        LstMoviesPresenter lstMoviesPresenter = new LstMoviesPresenter(this);
        lstMoviesPresenter.lstMovies("");

        Button btnEnviar = findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lstMoviesPresenter.lstMovies("");
            }
        });
    }


    @Override
    public void successMovies(ArrayList<Pelicula> lstPelicula) {
        Toast.makeText(this, lstPelicula.get(0).getTitulo(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, lstPelicula.get(0).getDescripcion(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void failureMovies(String err) {

    }
}