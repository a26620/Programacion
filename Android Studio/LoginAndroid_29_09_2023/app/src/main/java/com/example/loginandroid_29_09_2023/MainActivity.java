package com.example.loginandroid_29_09_2023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginandroid_29_09_2023.actions.ServicePeliculas;
import com.example.loginandroid_29_09_2023.actions.ViewPeliculas;

public class MainActivity extends AppCompatActivity
                        implements ViewPeliculas {
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;

    private ServicePeliculas sPeliculas =
                        new ServicePeliculas(this);
    /* PATRÓN SINGLETON*/
    private static MainActivity mainActivity = null;
    public static MainActivity getInstance(){
        return mainActivity; //0x457845AF
    }
    /* FIN PATRÓN SINGLETON*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
        initComponents();
    }
    private void initComponents(){
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

    }

    @Override
    public void showPeliculas(String message) {
        Toast.makeText(mainActivity, message, Toast.LENGTH_SHORT).show();
    }
}