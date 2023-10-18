package com.example.loginandroid_29_09_2023.actions;

import android.view.View;
import android.widget.Toast;

import com.example.loginandroid_29_09_2023.MainActivity;

public class ServicePeliculas {

    private ViewPeliculas view;
    public ServicePeliculas(ViewPeliculas view){
        this.view = view;
    }

    void getDatosPeliculas(){
        // Voy a por los datos
        // VIAJOOOOOOOOO A POR LOS DATOS!!!!!!!!!!!!
        // THREADS!!!!!!!!!!!!!!!!!!!!
        // RETROFIT!!!!!!!!!!!!
        // Toast.makeText(MainActivity.getInstance(), "Welcome To Miami!!!", Toast.LENGTH_SHORT).show();
        view.showPeliculas("Los datos han ido bien: ['films': {''}]");

        // fetch ("url=http://")-->
        // json


    }
}
