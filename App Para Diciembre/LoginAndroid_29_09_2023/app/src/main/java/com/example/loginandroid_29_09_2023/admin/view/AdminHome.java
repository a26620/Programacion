package com.example.loginandroid_29_09_2023.admin.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.add_obra.view.AddObra;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;

public class AdminHome extends AppCompatActivity {

    private Button btnViewCrear;

    private Button btnViewSalas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        initComponents();
    }

    private void initComponents(){
        btnViewCrear = findViewById(R.id.btnViewCrear);
        btnViewSalas = findViewById(R.id.btnViewSalas);
        btnViewCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(AdminHome.this,
                        AddObra.class);
                startActivity(mainIntent);
            }
        });
    }
}