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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginandroid_29_09_2023.Home;
import com.example.loginandroid_29_09_2023.OtherObra;
import com.example.loginandroid_29_09_2023.Profile;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.adaptadores.ObraSpinnerAdapter;
import com.example.loginandroid_29_09_2023.add_actuacion.ContractAddActuacion;
import com.example.loginandroid_29_09_2023.add_actuacion.presenter.AddActuacionPresenter;
import com.example.loginandroid_29_09_2023.beans.Compra;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.beans.Sala;
import com.example.loginandroid_29_09_2023.list_actuaciones.ContractListActuacion;
import com.example.loginandroid_29_09_2023.list_actuaciones.presenter.ListActuacionPresenter;
import com.example.loginandroid_29_09_2023.list_obra.ContractListObra;
import com.example.loginandroid_29_09_2023.list_obra.presenter.ListObraPresenter;
import com.example.loginandroid_29_09_2023.list_obra_filter.ContractListObraFilter;
import com.example.loginandroid_29_09_2023.list_obra_filter.presenter.ListObraFilterPresenter;
import com.example.loginandroid_29_09_2023.list_sala.ContractListSala;
import com.example.loginandroid_29_09_2023.list_sala.presenter.ListSalaPresenter;
import com.example.loginandroid_29_09_2023.list_sala.view.ListSala;

import java.util.ArrayList;
import java.util.Calendar;

public class AddActuacion extends AppCompatActivity implements ContractListSala.View, ContractListObraFilter.View, ContractAddActuacion.View {

    private EditText editTextFecha;
    private Button buttonAtras;
    private Button buttonCrear;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private Spinner spinnerHorarios;
    private Spinner spinnerSalas;
    private Spinner spinnerObras;
    private Obra obra = new Obra();
    private ListSalaPresenter listSalaPresenter= new ListSalaPresenter(this);
    private ListObraFilterPresenter listObraFilterPresenter= new ListObraFilterPresenter(this);
    private AddActuacionPresenter addActuacionPresenter= new AddActuacionPresenter(this);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_obrasala);
        initComponents();
    }
    private void initComponents(){
        ArrayList<Integer> id_genero = new ArrayList<>();
        ArrayList<Integer> edadRecomendada = new ArrayList<>();
        spinnerSalas = findViewById(R.id.spinnerSalas);
        spinnerObras = findViewById(R.id.spinnerObras);
        buttonAtras = findViewById(R.id.buttonAtras);
        buttonCrear = findViewById(R.id.buttonCrear);
        listSalaPresenter.listSala();
        listObraFilterPresenter.listObraFilter(id_genero,edadRecomendada,"");
        editTextFecha = findViewById(R.id.editTextFecha);
        final Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        String[] HORARIOS = {"16:00:00", "19:00:00", "22:00:00"};

            spinnerHorarios = findViewById(R.id.spinnerHorarios);

            // Crear un adaptador para el Spinner y establecer las opciones
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, HORARIOS);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerHorarios.setAdapter(adapter);

            // Agregar un Listener al Spinner si necesitas capturar la selección
            spinnerHorarios.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selected = HORARIOS[position];
                    obra.setHoraActuacion(selected);
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

        // Crear el DatePickerDialog
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // Actualizar el EditText con la fecha seleccionada
                editTextFecha.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                String fechaActuacion = editTextFecha.getText().toString();
                obra.setFechaActuacion(fechaActuacion);
            }
        };

        editTextFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddActuacion.this, dateSetListener, year, month, day);
                datePickerDialog.show();
            }
        });
        buttonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(AddActuacion.this,
                        ListSala.class);
                startActivity(mainIntent);
            }
        });
        buttonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addActuacionPresenter.add(obra);
                Intent mainIntent = new Intent(AddActuacion.this,
                        ListSala.class);
                startActivity(mainIntent);
            }
        });

    }

    @Override
    public void successLogin(ArrayList<Sala> listSala) {

        ArrayList<String> nombresSalas = new ArrayList<>();

        for (Sala sala : listSala) {
            nombresSalas.add(sala.getNombre());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nombresSalas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSalas.setAdapter(adapter);

        spinnerSalas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedSala = nombresSalas.get(position);
                obra.setId_sala(listSala.get(position).getId_sala());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void successLogin() {

    }

    @Override
    public void failureLogin(String err) {

    }

    @Override
    public void successlistObrasFilter(ArrayList<Obra> lstObra) {
        ArrayList<String> titulosObras = new ArrayList<>();

        for (Obra obra : lstObra) {
            titulosObras.add(obra.getTitulo());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, titulosObras);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerObras.setAdapter(adapter);

        spinnerObras.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedTitulo = titulosObras.get(position);
                obra.setId_obra(lstObra.get(position).getId_obra());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void failurelistObrasFilter(String err) {

    }
}
