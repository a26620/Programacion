package com.example.loginandroid_29_09_2023.adaptadores;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.admin.view.AdminHome;
import com.example.loginandroid_29_09_2023.beans.Sala;
import com.example.loginandroid_29_09_2023.list_obra.view.ListObra;
import com.example.loginandroid_29_09_2023.list_sala.view.ListSala;
import com.example.loginandroid_29_09_2023.login_user.view.LoginUserM;

import java.util.ArrayList;

public class listaAdminSala extends RecyclerView.Adapter<listaAdminSala.SalaViewHolder> {

    ArrayList<Sala> lstSala;
    Context context;

    public listaAdminSala(ArrayList<Sala> lstSala) {
        this.lstSala = lstSala;
    }

    @NonNull
    @Override
    public SalaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_adminsala,null,false);
        return new SalaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listaAdminSala.SalaViewHolder holder, int position) {
        holder.nombreSala.setText(lstSala.get(position).getNombre());
        holder.capacidadSala.setText("Capacidad: "+String.valueOf(lstSala.get(position).getCapacidad()));
        holder.itemView.setOnClickListener(v -> {
            Sala sala = lstSala.get(position);
            int id = sala.getId_sala();
            Intent intent = new Intent(holder.itemView.getContext(), ListObra.class);
            intent.putExtra("id", id);
            context.startActivity(intent);

        });
    }

    @Override
    public int getItemCount() {
        return lstSala.size();
    }

    public class SalaViewHolder extends RecyclerView.ViewHolder {

        TextView nombreSala, capacidadSala;

        public SalaViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreSala = itemView.findViewById(R.id.nombreSala);
            capacidadSala = itemView.findViewById(R.id.capacidadSala);
        }
    }
}
