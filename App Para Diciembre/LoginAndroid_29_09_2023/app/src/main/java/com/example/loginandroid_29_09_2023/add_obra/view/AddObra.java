package com.example.loginandroid_29_09_2023.add_obra.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginandroid_29_09_2023.MainActivity;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.add_obra.ContractAddObra;
import com.example.loginandroid_29_09_2023.add_obra.presenter.AddObraPresenter;
import com.example.loginandroid_29_09_2023.admin.view.AdminHome;
import com.example.loginandroid_29_09_2023.beans.Genero;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.beans.Sala;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.list_genero.ContractListGenero;
import com.example.loginandroid_29_09_2023.list_genero.presenter.ListGeneroPresenter;
import com.example.loginandroid_29_09_2023.list_sala.ContractListSala;
import com.example.loginandroid_29_09_2023.list_sala.presenter.ListSalaPresenter;
import com.example.loginandroid_29_09_2023.login_user.presenter.LoginUserPresenter;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddObra extends AppCompatActivity implements ContractAddObra.View, ContractListGenero.View {
    private EditText edtTitulo;
    private CardView edtImagen;
    private EditText edtDescripcion;
    private EditText edtPrecio;
    private EditText edtDuracion;
    private Spinner spinnerOptions;
    private Spinner spinnerEdad;
    private Button btnAddObra;
    private Button AOvolverAH;
    private String seleccionGenero;
    private String seleccionEdad;




    private AddObraPresenter presenter =
            new AddObraPresenter(this);

    private ListGeneroPresenter presenter2 =
            new ListGeneroPresenter(this);

    /* PATRÓN SINGLETON*/
    private static AddObra mainActivity = null;
    public static AddObra getInstance(){
        return mainActivity;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_obra);
        initComponents();
    }
    private void initComponents(){
        presenter2.listGeneros();
        edtTitulo = findViewById(R.id.edtTitulo);
        edtImagen = findViewById(R.id.edtImagen);
        edtDescripcion = findViewById(R.id.edtDescripcion);
        edtPrecio = findViewById(R.id.edtPrecio);
        btnAddObra = findViewById(R.id.btnAddObra);
        spinnerOptions = findViewById(R.id.spinnerGenero);
        spinnerEdad = findViewById(R.id.spinnerEdad);
        AOvolverAH = findViewById(R.id.AOvolverAH);
        edtDuracion = findViewById(R.id.edtDuracion);
        AOvolverAH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(AddObra.this,
                        AdminHome.class);
                startActivity(mainIntent);
            }
        });
        btnAddObra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Obra obra = new Obra();
                obra.setTitulo(edtTitulo.getText().toString());
                obra.setDescripcion(edtDescripcion.getText().toString());
                obra.setPrecio(Float.parseFloat(edtPrecio.getText().toString()));
                obra.setDuracion(Integer.valueOf(edtDuracion.getText().toString()));
                obra.setId_genero(Integer.valueOf(seleccionGenero));
                obra.setEdadRecomendada(Integer.valueOf(seleccionEdad));
                Log.e("seleccionEdad: ", seleccionEdad);
                Log.e("seleccionGenero: ", seleccionGenero);

                presenter.add(obra);
            }
        });
        ArrayList<String> valores = new ArrayList<>();
        valores.add("Edad Recomendada");
        valores.add("+0");
        valores.add("+3");
        valores.add("+7");
        valores.add("+12");
        valores.add("+16");
        valores.add("+18");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, valores);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerEdad.setAdapter(adapter);
        spinnerEdad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seleccionEdad = parent.getItemAtPosition(position).toString();
                seleccionEdad = seleccionEdad.substring(1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

    @Override
    public void successLogin() {
        Intent mainIntent = new Intent(AddObra.this,
                AdminHome.class);
        startActivity(mainIntent);
    }


    @Override
    public void successlistGeneros(ArrayList<Genero> listGeneros) {
        List<String> opcionesList = new ArrayList<>();
        opcionesList.add("Seleccione Género");

        for (Genero genero : listGeneros) {
            opcionesList.add(genero.getNombre());
        }
        String[] opciones = opcionesList.toArray(new String[opcionesList.size()]);
        String[] opcionesId = new String[opcionesList.size()];


        opciones[0] = "Seleccione Género";
        opcionesId[0] = "0";
        for (int i = 1; i < opcionesList.size(); i++) {
            Genero genero = listGeneros.get(i - 1);
            opciones[i] = genero.getNombre();
        }
        for (int i = 1; i < opcionesList.size(); i++) {
            Genero genero = listGeneros.get(i - 1);
            opcionesId[i] = String.valueOf(genero.getId_genero());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptions.setAdapter(adapter);
        spinnerOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seleccionGenero = opcionesId[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }


    @Override
    public void failureLogin(String err) {

    }
}