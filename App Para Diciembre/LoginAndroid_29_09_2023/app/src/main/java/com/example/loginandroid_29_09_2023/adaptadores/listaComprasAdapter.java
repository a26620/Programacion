package com.example.loginandroid_29_09_2023.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Compra;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.ficha_descriptiva.view.FichaDescriptiva;

import java.util.ArrayList;

public class listaComprasAdapter extends RecyclerView.Adapter<listaComprasAdapter.CompraViewHolder> {

    ArrayList<Compra> lstCompra;
    Context context;


    public listaComprasAdapter(ArrayList<Compra> lstCompra) {
        this.lstCompra = lstCompra;
    }

    @NonNull
    @Override
    public listaComprasAdapter.CompraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.compra_viewholder,null,false);
        return new listaComprasAdapter.CompraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listaComprasAdapter.CompraViewHolder holder, int position) {
        holder.fechaCompra.setText(lstCompra.get(position).getFechaCompra());
        holder.tituloObra.setText(lstCompra.get(position).getTituloObra());
        holder.nEntradas.setText(String.valueOf(lstCompra.get(position).getnEntradas())+" Entradas");
        holder.precioTotal.setText(String.valueOf(lstCompra.get(position).getImporte())+"€ ");
    }

    @Override
    public int getItemCount() {
        return lstCompra.size();
    }

    public class CompraViewHolder extends RecyclerView.ViewHolder {

        TextView fechaCompra,tituloObra,nEntradas,precioTotal;

        public CompraViewHolder(@NonNull View itemView) {
            super(itemView);

            fechaCompra = itemView.findViewById(R.id.fechaCompra);
            tituloObra = itemView.findViewById(R.id.tituloObra);
            nEntradas = itemView.findViewById(R.id.nEntradas);
            precioTotal = itemView.findViewById(R.id.precioTotal);
        }
    }
}
