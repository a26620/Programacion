package com.example.loginandroid_29_09_2023.list_sala.view;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import static com.google.android.material.internal.ViewUtils.dpToPx;
import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Sala;
import com.example.loginandroid_29_09_2023.list_sala.ContractListSala;
import com.example.loginandroid_29_09_2023.list_sala.presenter.ListSalaPresenter;

import java.util.ArrayList;

public class ListSala extends AppCompatActivity implements ContractListSala.View {

    private ListSalaPresenter presenter =
            new ListSalaPresenter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sala);
        initComponents();
    }

    private void initComponents(){
        presenter.listSala();
    }

    @Override
    public void successLogin(ArrayList<Sala> listSala) {

    }

    @Override
    public void failureLogin(String err) {

    }
}