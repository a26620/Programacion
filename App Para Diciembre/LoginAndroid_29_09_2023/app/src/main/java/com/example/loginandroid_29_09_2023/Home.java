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
import android.util.Log;
import android.view.View;
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

public class Home extends AppCompatActivity implements ContractListObraMostSell.View, ContractListObraBestRating.View, ContractListObraFilter.View {


    SharedPreferences sharedPreferencesUserCFG;

    private ListObraMostSellPresenter presenter =
            new ListObraMostSellPresenter(this);

    private ListObraBestRatingPresenter presenter2 =
            new ListObraBestRatingPresenter(this);

    private ListObraFilterPresenter presenter3 =
            new ListObraFilterPresenter(this);

    private RecyclerView listaMostSell;
    private RecyclerView listaBestRating;
    private RecyclerView listaFilter;
    private ImageView btnLogOut;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initComponents();
        NestedScrollView nestedScrollView = findViewById(R.id.nestedScrollView);
        nestedScrollView.post(() -> nestedScrollView.scrollTo(0, 0));

    }

    private void initComponents() {
        sharedPreferencesUserCFG = getSharedPreferences("com.MyApp.USER_CFG", Context.MODE_PRIVATE);
        presenter.listObraMostSell();
        presenter2.listObraBestRating();
        ArrayList<Integer> id_genero = new ArrayList<>(); // Inicializa id_genero
        ArrayList<Integer> edadRecomendada = new ArrayList<>(); // Inicializa id_genero
        listaMostSell = findViewById(R.id.listaMostSell);
        listaBestRating = findViewById(R.id.listaBestRating);
        listaFilter = findViewById(R.id.listaFilter);
        btnLogOut = findViewById(R.id.btnLogOut);
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
        operaFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operaFilteractive == false) {
                    operaFilteractive = true;
                    id_genero.add(4);
                    operaFilter.setCardBackgroundColor(Color.BLUE);
                    presenter3.listObraFilter(id_genero, edadRecomendada);

                } else {
                    operaFilter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = id_genero.size() - 1; i >= 0; i--) {
                        if (id_genero.get(i) == 4) {
                            id_genero.remove(i);
                        }
                    }
                    operaFilteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada);
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
                    presenter3.listObraFilter(id_genero, edadRecomendada);

                } else {
                    teatroFilter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = id_genero.size() - 1; i >= 0; i--) {
                        if (id_genero.get(i) == 1) {
                            id_genero.remove(i);
                        }
                    }
                    teatroFilteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada);
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
                    presenter3.listObraFilter(id_genero, edadRecomendada);

                } else {
                    musicalFilter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = id_genero.size() - 1; i >= 0; i--) {
                        if (id_genero.get(i) == 2) {
                            id_genero.remove(i);
                        }
                    }
                    musicalFilteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada);
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
                    presenter3.listObraFilter(id_genero, edadRecomendada);

                } else {
                    balletFilter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = id_genero.size() - 1; i >= 0; i--) {
                        if (id_genero.get(i) == 3) {
                            id_genero.remove(i);
                        }
                    }
                    balletFilteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada);
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
                    presenter3.listObraFilter(id_genero, edadRecomendada);

                } else {
                    Ed0Filter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = edadRecomendada.size() - 1; i >= 0; i--) {
                        if (edadRecomendada.get(i) == 0) {
                            edadRecomendada.remove(i);
                        }
                    }
                    Ed0Filteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada);
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
                    presenter3.listObraFilter(id_genero, edadRecomendada);
                } else {
                    Ed3Filter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = edadRecomendada.size() - 1; i >= 0; i--) {
                        if (edadRecomendada.get(i) == 3) {
                            edadRecomendada.remove(i);
                        }
                    }
                    Ed3Filteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada);
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
                    presenter3.listObraFilter(id_genero, edadRecomendada);
                } else {
                    Ed7Filter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = edadRecomendada.size() - 1; i >= 0; i--) {
                        if (edadRecomendada.get(i) == 7) {
                            edadRecomendada.remove(i);
                        }
                    }
                    Ed7Filteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada);
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
                    presenter3.listObraFilter(id_genero, edadRecomendada);
                } else {
                    Ed12Filter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = edadRecomendada.size() - 1; i >= 0; i--) {
                        if (edadRecomendada.get(i) == 12) {
                            edadRecomendada.remove(i);
                        }
                    }
                    Ed12Filteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada);
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
                    presenter3.listObraFilter(id_genero, edadRecomendada);
                } else {
                    Ed16Filter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = edadRecomendada.size() - 1; i >= 0; i--) {
                        if (edadRecomendada.get(i) == 16) {
                            edadRecomendada.remove(i);
                        }
                    }
                    Ed16Filteractive = false;
                    presenter3.listObraFilter(id_genero, edadRecomendada);
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
                    presenter3.listObraFilter(id_genero, edadRecomendada);
                } else {
                    Ed18Filter.setCardBackgroundColor(Color.parseColor("#BB86FC"));
                    for (int i = edadRecomendada.size() - 1; i >= 0; i--) {
                        if (edadRecomendada.get(i) == 18) {
                            edadRecomendada.remove(i);
                        }
                    }
                    Ed18Filteractive = false;

                    presenter3.listObraFilter(id_genero, edadRecomendada);
                }
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
                Intent mainIntent = new Intent(Home.this,
                        LoginUserM.class);
                startActivity(mainIntent);
            }
        });
        listaFilter.addOnScrollListener(new RecyclerView.OnScrollListener() {
            boolean isScrolledToBottom = false;

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                isScrolledToBottom = !recyclerView.canScrollVertically(1);

                if (isScrolledToBottom) {
                    return;
                }
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE && isScrolledToBottom) {
                    NestedScrollView nestedScrollView = findViewById(R.id.nestedScrollView);
                    nestedScrollView.post(() -> nestedScrollView.fullScroll(View.FOCUS_DOWN));
                }
            }
        });
        listaFilter.addOnScrollListener(new RecyclerView.OnScrollListener() {
            boolean isScrolledToBottom = false;

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                isScrolledToBottom = !recyclerView.canScrollVertically(1);

                if (isScrolledToBottom) {
                    return;
                }
            }

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE && isScrolledToBottom) {
                    NestedScrollView nestedScrollView = findViewById(R.id.nestedScrollView);
                    nestedScrollView.post(() -> nestedScrollView.fullScroll(View.FOCUS_DOWN));
                }
            }
        });

        presenter3.listObraFilter(id_genero, edadRecomendada);

    }

    @Override
    public void successlistObrasMostSell(ArrayList<Obra> lstObra) {
        listaMostSellObra adapterListaMostSell = new listaMostSellObra(lstObra);
        listaMostSell.setAdapter(adapterListaMostSell);
        listaMostSell.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void failureLogin(String err) {

    }


    @Override
    public void successlistObrasBestRating(ArrayList<Obra> lstObra) {
        listaBestRatingObra adapterListaBestRating = new listaBestRatingObra(lstObra);
        listaBestRating.setAdapter(adapterListaBestRating);
        listaBestRating.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    @Override
    public void failurelistObrasBestRating(String err) {

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
        Log.e("failurelistObrasFilter: ","DENTROOOO" );
        ArrayList<Obra> lstObra = null;
        listaFilterObra adapterListaAllObra = new listaFilterObra(lstObra);
        listaFilter.setAdapter(adapterListaAllObra);
        listaFilter.setLayoutManager(new GridLayoutManager(this, 3));
        listaFilter.setNestedScrollingEnabled(false);
    }


}