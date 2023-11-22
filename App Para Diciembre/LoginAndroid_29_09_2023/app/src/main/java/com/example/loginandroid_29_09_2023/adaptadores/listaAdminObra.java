package com.example.loginandroid_29_09_2023.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Obra;


import java.util.ArrayList;

public class listaAdminObra extends RecyclerView.Adapter<listaAdminObra.ObraViewHolder> {

    ArrayList<Obra> lstObra;

    public listaAdminObra(ArrayList<Obra> lstObra) {
        this.lstObra = lstObra;
    }

    @NonNull
    @Override
    public listaAdminObra.ObraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista_adminobra,null,false);
        return new listaAdminObra.ObraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listaAdminObra.ObraViewHolder holder, int position) {
        holder.nombreObra.setText(lstObra.get(position).getTitulo());
        holder.fechaActuacion.setText(lstObra.get(position).getFechaActuacion());
    }

    @Override
    public int getItemCount() {
        return lstObra.size();
    }

    public class ObraViewHolder extends RecyclerView.ViewHolder {

        TextView nombreObra, fechaActuacion;

        public ObraViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreObra = itemView.findViewById(R.id.nombreObra);
            fechaActuacion = itemView.findViewById(R.id.fechaActuacion);
        }
    }
}
