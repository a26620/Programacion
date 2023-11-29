package com.example.loginandroid_29_09_2023.admin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.loginandroid_29_09_2023.Home;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.add_obra.view.AddObra;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.list_sala.view.ListSala;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;

public class AdminHome extends AppCompatActivity {

    SharedPreferences sharedPreferencesUserCFG;

    private Button btnViewCrear;

    private Button btnViewSalas;

    private Button btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        initComponents();
    }

    private void initComponents(){
        sharedPreferencesUserCFG = getSharedPreferences("com.MyApp.USER_CFG", Context.MODE_PRIVATE);
        btnViewCrear = findViewById(R.id.btnViewCrear);
        btnViewSalas = findViewById(R.id.btnViewSalas);
        btnLogOut = findViewById(R.id.btnLogOut);
        btnViewCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(AdminHome.this,
                        AddObra.class);
                startActivity(mainIntent);
            }
        });
        btnViewSalas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(AdminHome.this,
                        ListSala.class);
                startActivity(mainIntent);
            }
        });
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferencesUserCFG.edit();
                editor.remove("isLoggedIn");
                editor.remove("username");
                editor.remove("id_user");
                editor.apply();
                Intent mainIntent = new Intent(AdminHome.this,
                        LoginUserM.class);
                startActivity(mainIntent);
            }
        });
    }
}