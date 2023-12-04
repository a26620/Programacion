package com.example.loginandroid_29_09_2023.add_actuacion.view;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginandroid_29_09_2023.Home;
import com.example.loginandroid_29_09_2023.Profile;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.adaptadores.ObraSpinnerAdapter;
import com.example.loginandroid_29_09_2023.add_actuacion.ContractAddActuacion;
import com.example.loginandroid_29_09_2023.add_actuacion.presenter.AddActuacionPresenter;
import com.example.loginandroid_29_09_2023.beans.Compra;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.list_actuaciones.ContractListActuacion;
import com.example.loginandroid_29_09_2023.list_actuaciones.presenter.ListActuacionPresenter;

import java.util.ArrayList;
import java.util.Calendar;

public class AddActuacion extends AppCompatActivity{

    private EditText editTextFecha;
    private DatePickerDialog.OnDateSetListener dateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_obrasala);
        initComponents();
    }
    private void initComponents(){
        editTextFecha = findViewById(R.id.editTextFecha);

        // Obtener la fecha actual
        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        // Crear el DatePickerDialog
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Actualizar el EditText con la fecha seleccionada
                editTextFecha.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
            }
        };

        // Configurar el clic en el EditText para abrir el DatePickerDialog
        editTextFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddActuacion.this,
                        dateSetListener,
                        year,
                        month,
                        day);
                datePickerDialog.show();
            }
        });
    }
}
