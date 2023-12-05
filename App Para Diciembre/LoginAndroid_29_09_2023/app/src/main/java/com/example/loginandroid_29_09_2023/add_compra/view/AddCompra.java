package com.example.loginandroid_29_09_2023.add_compra.view;

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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginandroid_29_09_2023.Home;
import com.example.loginandroid_29_09_2023.Profile;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.adaptadores.ObraSpinnerAdapter;
import com.example.loginandroid_29_09_2023.add_compra.ContractAddCompra;
import com.example.loginandroid_29_09_2023.add_compra.presenter.AddCompraPresenter;
import com.example.loginandroid_29_09_2023.add_obra.ContractAddObra;
import com.example.loginandroid_29_09_2023.add_valoracion.ContractAddValoracion;
import com.example.loginandroid_29_09_2023.add_valoracion.presenter.AddValoracionPresenter;
import com.example.loginandroid_29_09_2023.beans.Compra;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.ficha_descriptiva.presenter.FichaDescriptivaPresenter;
import com.example.loginandroid_29_09_2023.ficha_descriptiva.view.FichaDescriptiva;
import com.example.loginandroid_29_09_2023.list_actuaciones.ContractListActuacion;
import com.example.loginandroid_29_09_2023.list_actuaciones.presenter.ListActuacionPresenter;

import java.util.ArrayList;

public class AddCompra extends AppCompatActivity implements ContractListActuacion.View, ContractAddCompra.View {

    SharedPreferences sharedPreferencesUserCFG;


    private ListActuacionPresenter listActuacionPresenter =
            new ListActuacionPresenter(this);
    private AddCompraPresenter addCompraPresenter =
            new AddCompraPresenter(this);

    private EditText EdtnEntradas;
    private TextView precioTotal;
    private Spinner spinnerActuaciones;
    private Button CancelarBtn;
    private float precioEntrada;
    private Button ComprarBtn;

    private Compra compra = new Compra();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);
        initComponents();
    }
    private void initComponents(){
        sharedPreferencesUserCFG = getSharedPreferences("com.MyApp.USER_CFG", Context.MODE_PRIVATE);
        int id_user = sharedPreferencesUserCFG.getInt("id_user", 0);
        Intent intent = getIntent();
        int id_obra = intent.getIntExtra("id_obra",0);
        EdtnEntradas = findViewById(R.id.EdtnEntradas);
        precioTotal = findViewById(R.id.precioTotal);
        spinnerActuaciones = findViewById(R.id.spinnerActuaciones);
        CancelarBtn = findViewById(R.id.CancelarBtn);
        ComprarBtn = findViewById(R.id.ComprarBtn);
        listActuacionPresenter.listActuacions(id_obra);
        CancelarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(AddCompra.this,
                        Home.class);
                startActivity(mainIntent);
            }
        });
        ComprarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean comprar = false;
                String precioString = precioTotal.getText().toString().replace("€", "");
                compra.setImporte(Float.valueOf(precioString));
                compra.setId_user(id_user);
                String textEntradas = EdtnEntradas.getText().toString();
                if (!textEntradas.isEmpty()) {
                    int nEntradas = Integer.parseInt(textEntradas);
                    compra.setnEntradas(nEntradas);
                    comprar = true;
                }
                if (comprar == true){
                    addCompraPresenter.add(compra);
                    Intent mainIntent = new Intent(AddCompra.this,
                            Profile.class);
                    startActivity(mainIntent);
                }

            }
        });



        EdtnEntradas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String TextnEntradas = EdtnEntradas.getText().toString();

                // Verificar si el texto no está vacío
                if (!TextnEntradas.isEmpty()) {
                    int value = Integer.parseInt(TextnEntradas);
                    float result = value * precioEntrada;

                    // Convertir el resultado a String para mostrarlo en el TextView
                    precioTotal.setText(String.valueOf(result) + "€");
                } else {
                    precioTotal.setText("0€");
                }
            }
        });

    }

    @Override
    public void successlistActuacions(ArrayList<Obra> lstObra) {
        ObraSpinnerAdapter adapter = new ObraSpinnerAdapter(this, lstObra);
        spinnerActuaciones.setAdapter(adapter);
        float Entrada = lstObra.get(0).getPrecio();
        Log.e("VALOOOOOOOR ENTRADA: ", String.valueOf(Entrada));
        precioEntrada = Entrada;
        spinnerActuaciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Obra obraSeleccionada = lstObra.get(position);

                int idActuacion = obraSeleccionada.getId_actuacion();
                compra.setId_actuacion(idActuacion);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Manejar el caso en que no se ha seleccionado ningún elemento
            }
        });

    }


    @Override
    public void successLogin() {

    }

    @Override
    public void failureLogin(String err) {

    }
}
