package com.example.login_03102023.actions;

import android.view.View;
import android.widget.Toast;

import com.example.login_03102023.MainActivity;

public class ServicePeliculas {


    private ViewPeliculas view;

    public ServicePeliculas(ViewPeliculas view){
        this.view = view;
    }



    void getDatosPeliculas(){
        //Voy a por los dates
        //VIAJOOOOO A POR LOS DATOS!!!
        //THREADS!!!!!!
        //RETROFIT!!!
        //Toast.makeText(MainActivity.getInstance(),"Welcome To Miami",Toast.LENGTH_SHORT).show();
        view.showPeliculas("Los datos han ido bien: ['films' : {''}]");

        // fetch ("url=http://")-->
        // json
    }
}
