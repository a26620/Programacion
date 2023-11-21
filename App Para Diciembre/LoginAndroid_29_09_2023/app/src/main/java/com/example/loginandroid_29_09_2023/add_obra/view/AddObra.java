package com.example.loginandroid_29_09_2023.add_obra.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
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
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.beans.Sala;
import com.example.loginandroid_29_09_2023.beans.User;
import com.example.loginandroid_29_09_2023.list_sala.ContractListSala;
import com.example.loginandroid_29_09_2023.list_sala.presenter.ListSalaPresenter;
import com.example.loginandroid_29_09_2023.login_user.presenter.LoginUserPresenter;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddObra extends AppCompatActivity implements ContractAddObra.View, ContractListSala.View {
    private EditText edtTitulo;
    private EditText edtImagen;
    private EditText edtDescripcion;
    private EditText edtPrecio;
    private EditText edtFecha;
    private Spinner spinnerOptions;
    private String selectedDate;
    private Button btnAddObra;
    private String seleccion;
    private int IdSala;

    private ArrayList<Sala> listSalas;




    private AddObraPresenter presenter =
            new AddObraPresenter(this);

    private ListSalaPresenter presenter2 =
            new ListSalaPresenter(this);

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
        presenter2.listSala();
        edtTitulo = findViewById(R.id.edtTitulo);
        edtImagen = findViewById(R.id.edtImagen);
        edtDescripcion = findViewById(R.id.edtDescripcion);
        edtPrecio = findViewById(R.id.edtPrecio);
        btnAddObra = findViewById(R.id.btnAddObra);
        edtFecha = findViewById(R.id.edtFecha);
        spinnerOptions = findViewById(R.id.spinnerOptions);
        btnAddObra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mainActivity, message, Toast.LENGTH_SHORT).show();
                //sPeliculas.getDatosPeliculas();
                Obra obra = new Obra();
                obra.setTitulo(edtTitulo.getText().toString());
                obra.setDescripcion(edtDescripcion.getText().toString());
                obra.setImg(edtImagen.getText().toString());
                obra.setPrecio(Float.parseFloat(edtPrecio.getText().toString()));
                obra.setFechaActuacion(edtFecha.getText().toString());
                Log.e("onClick: ", String.valueOf(IdSala));
                for (Sala sala : listSalas) {
                    Log.e("GetNombre: ", String.valueOf(sala.getNombre()));
                    if (sala.getNombre() == seleccion) {
                        Log.e("For: ", String.valueOf(sala.getId_sala()));
                        IdSala = sala.getId_sala();
                    }
                }
                obra.setId_sala(IdSala);
                presenter.add(obra);
            }
        });
        edtFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        AddObra.this, // Reemplaza "NombreDeTuActivity" por el nombre de tu actividad
                        (view, selectedYear, selectedMonth, selectedDayOfMonth) -> {
                            selectedDate = selectedDayOfMonth + "/" + (selectedMonth + 1) + "/" + selectedYear;
                            edtFecha.setText(selectedDate);
                        },
                        year, month, dayOfMonth);

                datePickerDialog.show();
            }
        });


    }

    @Override
    public void successLogin(Obra obra) {

    }

    @Override
    public void successLogin(ArrayList<Sala> listSala) {
        Log.e("successLogin: ",listSala.toString() );
        listSalas = listSala;

        List<String> opcionesList = new ArrayList<>();
        opcionesList.add("Seleccione Sala");

        for (Sala sala : listSala) {
            opcionesList.add(sala.getNombre());
        }

        // Convertir el ArrayList a un array si es necesario
        String[] opciones = opcionesList.toArray(new String[opcionesList.size()]);

        opciones[0] = "Seleccione Sala";
        // Iteras sobre la lista de salas y añades cada nombre al array 'opciones'
        for (int i = 1; i < opcionesList.size(); i++) {
            Sala sala = listSala.get(i-1);
            opciones[i] = sala.getNombre();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);

        // Define el diseño del dropdown del Spinner
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Aplica el adaptador al Spinner
        spinnerOptions.setAdapter(adapter);

        // Manejar la selección del elemento en el Spinner (opcional)
        spinnerOptions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                seleccion = parent.getItemAtPosition(position).toString();
                // Haz algo con la opción seleccionada (A, B, C)
                // Por ejemplo: muestra un mensaje con la opción seleccionada
                Toast.makeText(AddObra.this, "Seleccionaste: " + seleccion, Toast.LENGTH_SHORT).show();
            }



            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Acciones si no se selecciona nada (opcional)
            }
        });

    }

    @Override
    public void failureLogin(String err) {

    }
}