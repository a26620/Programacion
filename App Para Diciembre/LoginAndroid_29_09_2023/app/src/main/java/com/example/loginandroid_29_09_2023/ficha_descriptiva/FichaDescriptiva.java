package com.example.loginandroid_29_09_2023.ficha_descriptiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.loginandroid_29_09_2023.R;

public class FichaDescriptiva extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_descriptiva);
        initComponents();
    }

    private void initComponents(){
        Intent intent = getIntent();
    }
}