package com.example.loginandroid_29_09_2023;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.loginandroid_29_09_2023.adaptadores.listaBestRatingObra;
import com.example.loginandroid_29_09_2023.adaptadores.listaFilterObra;
import com.example.loginandroid_29_09_2023.adaptadores.listaMostSellObra;
import com.example.loginandroid_29_09_2023.admin.view.AdminHome;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.list_obra_best_rating.ContractListObraBestRating;
import com.example.loginandroid_29_09_2023.list_obra_best_rating.presenter.ListObraBestRatingPresenter;
import com.example.loginandroid_29_09_2023.list_obra_filter.ContractListObraFilter;
import com.example.loginandroid_29_09_2023.list_obra_filter.presenter.ListObraFilterPresenter;
import com.example.loginandroid_29_09_2023.list_sala.view.ListSala;
import com.example.loginandroid_29_09_2023.lista_obra_most_sell.ContractListObraMostSell;
import com.example.loginandroid_29_09_2023.lista_obra_most_sell.presenter.ListObraMostSellPresenter;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;

import java.util.ArrayList;

public class Home extends AppCompatActivity implements ContractListObraFilter.View {


    SharedPreferences sharedPreferencesUserCFG;

    private ListObraFilterPresenter presenter3 =
            new ListObraFilterPresenter(this);

    private RecyclerView listaFilter;
    private int edadRecomendada;
    private CardView operaFilter;
    private CardView teatroFilter;
    private CardView musicalFilter;
    private CardView balletFilter;
    private boolean operaFilteractive;
    private boolean teatroFilteractive;
    private boolean musicalFilteractive;
    private boolean balletFilteractive;
    private CardView Ed0Filter;
    private CardView Ed3Filter;
    private CardView Ed7Filter;
    private CardView Ed12Filter;
    private CardView Ed16Filter;
    private CardView Ed18Filter;
    private boolean Ed0Filteractive;
    private boolean Ed3Filteractive;
    private boolean Ed7Filteractive;
    private boolean Ed12Filteractive;
    private boolean Ed16Filteractive;
    private boolean Ed18Filteractive;
    private ImageButton homebtn;
    private ImageButton communbtn;
    private ImageButton profilebtn;
    private EditText edtBusquedaTitulo;
    private String titulo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initComponents();

    }

    private void initComponents() {
        sharedPreferencesUserCFG = getSharedPreferences("com.MyApp.USER_CFG", Context.MODE_PRIVATE);
        ArrayList<Integer> id_genero = new ArrayList<>(); // Inicializa id_genero
        ArrayList<Integer> edadRecomendada = new ArrayList<>(); // Inicializa id_genero
        listaFilter = findViewById(R.id.listaFilter);
        operaFilter = findViewById(R.id.operaFilter);
        teatroFilter = findViewById(R.id.teatroFilter);
        balletFilter = findViewById(R.id.balletFilter);
        musicalFilter = findViewById(R.id.musicalFilter);
        Ed0Filter = findViewById(R.id.Ed0Filter);
        Ed3Filter = findViewById(R.id.Ed3Filter);
        Ed7Filter = findViewById(R.id.Ed7Filter);
        Ed12Filter = findViewById(R.id.Ed12Filter);
        Ed16Filter = findViewById(R.id.Ed16Filter);
        Ed18Filter = findViewById(R.id.Ed18Filter);
        homebtn = findViewById(R.id.homebtn);
        communbtn = findViewById(R.id.communbtn);
        profilebtn = findViewById(R.id.profilebtn);
        operaFilteractive = false;
        teatroFilteractive = false;
        musicalFilteractive = false;
        balletFilteractive = false;
        Ed0Filteractive = false;
        Ed3Filteractive = false;
        Ed7Filteractive = false;
        Ed12Filteractive = false;
        Ed16Filteractive = false;
        Ed18Filteractive = false;
        edtBusquedaTitulo = findViewById(R.id.edtBusquedaTitulo); // Reemplaza con tu ID

        // Agrega un TextWatcher al EditText
        edtBusquedaTitulo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                titulo = charSequence.toString();
                presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
        communbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Home.this,
                        OtherObra.class);
                startActivity(mainIntent);
            }
        });
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainIntent = new Intent(Home.this,
                        Profile.class);
                startActivity(mainIntent);
            }
        });
        operaFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operaFilteractive == false) {
                    operaFilteractive = true;
                    id_genero.add(4);
                    operaFilter.setCardBackgroundColor(Color.BLUE);
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                } else {
                    operaFilter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = id_genero.size() - 1; i >= 0; i--) {
                        if (id_genero.get(i) == 4) {
                            id_genero.remove(i);
                        }
                    }
                    operaFilteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                }
            }
        });
        teatroFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (teatroFilteractive == false) {
                    teatroFilteractive = true;
                    id_genero.add(1);
                    teatroFilter.setCardBackgroundColor(Color.BLUE);
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                } else {
                    teatroFilter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = id_genero.size() - 1; i >= 0; i--) {
                        if (id_genero.get(i) == 1) {
                            id_genero.remove(i);
                        }
                    }
                    teatroFilteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                }
            }
        });
        musicalFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (musicalFilteractive == false) {
                    musicalFilteractive = true;
                    id_genero.add(2);
                    musicalFilter.setCardBackgroundColor(Color.BLUE);
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                } else {
                    musicalFilter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = id_genero.size() - 1; i >= 0; i--) {
                        if (id_genero.get(i) == 2) {
                            id_genero.remove(i);
                        }
                    }
                    musicalFilteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                }
            }
        });
        balletFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (balletFilteractive == false) {
                    balletFilteractive = true;
                    id_genero.add(3);
                    balletFilter.setCardBackgroundColor(Color.BLUE);
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                } else {
                    balletFilter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = id_genero.size() - 1; i >= 0; i--) {
                        if (id_genero.get(i) == 3) {
                            id_genero.remove(i);
                        }
                    }
                    balletFilteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                }
            }
        });
        Ed0Filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Ed0Filteractive == false) {
                    Ed0Filteractive = true;
                    edadRecomendada.add(0);
                    Ed0Filter.setCardBackgroundColor(Color.BLUE);
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                } else {
                    Ed0Filter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = edadRecomendada.size() - 1; i >= 0; i--) {
                        if (edadRecomendada.get(i) == 0) {
                            edadRecomendada.remove(i);
                        }
                    }
                    Ed0Filteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                }
            }
        });
        Ed3Filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Ed3Filteractive == false) {
                    Ed3Filteractive = true;
                    edadRecomendada.add(3);
                    Ed3Filter.setCardBackgroundColor(Color.BLUE);
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                } else {
                    Ed3Filter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = edadRecomendada.size() - 1; i >= 0; i--) {
                        if (edadRecomendada.get(i) == 3) {
                            edadRecomendada.remove(i);
                        }
                    }
                    Ed3Filteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                }
            }
        });
        Ed7Filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Ed7Filteractive == false) {
                    Ed7Filteractive = true;
                    edadRecomendada.add(7);
                    Ed7Filter.setCardBackgroundColor(Color.BLUE);
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                } else {
                    Ed7Filter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = edadRecomendada.size() - 1; i >= 0; i--) {
                        if (edadRecomendada.get(i) == 7) {
                            edadRecomendada.remove(i);
                        }
                    }
                    Ed7Filteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                }
            }
        });
        Ed12Filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Ed12Filteractive == false) {
                    Ed12Filteractive = true;
                    edadRecomendada.add(12);
                    Ed12Filter.setCardBackgroundColor(Color.BLUE);
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                } else {
                    Ed12Filter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = edadRecomendada.size() - 1; i >= 0; i--) {
                        if (edadRecomendada.get(i) == 12) {
                            edadRecomendada.remove(i);
                        }
                    }
                    Ed12Filteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                }
            }
        });
        Ed16Filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Ed16Filteractive == false) {
                    Ed16Filteractive = true;
                    edadRecomendada.add(16);
                    Ed16Filter.setCardBackgroundColor(Color.BLUE);
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                } else {
                    Ed16Filter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = edadRecomendada.size() - 1; i >= 0; i--) {
                        if (edadRecomendada.get(i) == 16) {
                            edadRecomendada.remove(i);
                        }
                    }
                    Ed16Filteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                }
            }
        });
        Ed18Filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Ed18Filteractive == false) {
                    Ed18Filteractive = true;
                    edadRecomendada.add(18);
                    Ed18Filter.setCardBackgroundColor(Color.BLUE);
                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                } else {
                    Ed18Filter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = edadRecomendada.size() - 1; i >= 0; i--) {
                        if (edadRecomendada.get(i) == 18) {
                            edadRecomendada.remove(i);
                        }
                    }
                    Ed18Filteractive = false;

                    presenter3.listObraFilter(id_genero, edadRecomendada, titulo);
                }
            }
        });

        presenter3.listObraFilter(id_genero, edadRecomendada, titulo);

    }

    @Override
    public void successlistObrasFilter(ArrayList<Obra> lstObra) {
        listaFilterObra adapterListaAllObra = new listaFilterObra(lstObra);
        listaFilter.setAdapter(adapterListaAllObra);
        listaFilter.setLayoutManager(new GridLayoutManager(this, 3));
        listaFilter.setNestedScrollingEnabled(false);
    }

    @Override
    public void failurelistObrasFilter(String err) {
        Log.e("failurelistObrasFilter: ", "DENTROOOO");
        ArrayList<Obra> lstObra = null;
        listaFilterObra adapterListaAllObra = new listaFilterObra(lstObra);
        listaFilter.setAdapter(adapterListaAllObra);
        listaFilter.setLayoutManager(new GridLayoutManager(this, 3));
        listaFilter.setNestedScrollingEnabled(false);
    }


}