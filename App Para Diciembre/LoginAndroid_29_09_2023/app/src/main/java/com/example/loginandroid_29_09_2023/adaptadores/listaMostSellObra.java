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
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.ficha_descriptiva.view.FichaDescriptiva;

import java.util.ArrayList;

public class listaMostSellObra extends RecyclerView.Adapter<listaMostSellObra.ObraViewHolder> {

    ArrayList<Obra> lstObra;
    Context context;


    public listaMostSellObra(ArrayList<Obra> lstObra) {
        this.lstObra = lstObra;
    }

    @NonNull
    @Override
    public listaMostSellObra.ObraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_obra,null,false);
        return new listaMostSellObra.ObraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull listaMostSellObra.ObraViewHolder holder, int position) {
        holder.nombreObra.setText(lstObra.get(position).getTitulo());
        holder.itemView.setOnClickListener(v -> {
            Obra obra = lstObra.get(position);
            int id_obra = obra.getId_obra();
            Intent intent = new Intent(holder.itemView.getContext(), FichaDescriptiva.class);
            intent.putExtra("id_obra", id_obra);
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
