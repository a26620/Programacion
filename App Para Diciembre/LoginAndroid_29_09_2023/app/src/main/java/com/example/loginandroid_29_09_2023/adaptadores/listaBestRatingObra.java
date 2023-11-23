package com.example.loginandroid_29_09_2023.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginandroid_29_09_2023.R;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.ficha_descriptiva.FichaDescriptiva;

import java.util.ArrayList;

public class listaBestRatingObra extends RecyclerView.Adapter<listaBestRatingObra.ObraViewHolder> {

    ArrayList<Obra> lstObra;
    Context context;


    public listaBestRatingObra(ArrayList<Obra> lstObra) {
        this.lstObra = lstObra;
    }

    @NonNull
    @Override
    public listaBestRatingObra.ObraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_obra,null,false);
        return new listaBestRatingObra.ObraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listaBestRatingObra.ObraViewHolder holder, int position) {
        holder.nombreObra.setText(lstObra.get(position).getTitulo());
        Log.e("ASAAAAAAAAAAAAAAAAAAAAAAAAAAA:" , lstObra.get(position).getTitulo());
        holder.itemView.setOnClickListener(v -> {
            Obra obra = lstObra.get(position);
            int id_obra = obra.getId_obra();
            String titulo = obra.getTitulo();
            String descripcion = obra.getDescripcion();
            Float precio = obra.getPrecio();
            int valoracionMedia = obra.getValoracionMedia();
            int edadRecomendada = obra.getEdadRecomendada();
            Intent intent = new Intent(holder.itemView.getContext(), FichaDescriptiva.class);
            intent.putExtra("id_obra", id_obra);
            intent.putExtra("titulo", titulo);
            intent.putExtra("descripcion", descripcion);
            intent.putExtra("precio", precio);
            intent.putExtra("valoracionMedia", valoracionMedia);
            intent.putExtra("edadRecomendada", edadRecomendada);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return lstObra.size();
    }

    public class ObraViewHolder extends RecyclerView.ViewHolder {

        TextView nombreObra;

        public ObraViewHolder(@NonNull View itemView) {
            super(itemView);

            nombreObra = itemView.findViewById(R.id.nombreObra);
        }
    }
}
