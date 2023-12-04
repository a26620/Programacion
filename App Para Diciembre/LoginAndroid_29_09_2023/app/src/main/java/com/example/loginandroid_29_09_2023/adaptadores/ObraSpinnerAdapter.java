package com.example.loginandroid_29_09_2023.adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.loginandroid_29_09_2023.beans.Obra;

import java.util.ArrayList;

public class ObraSpinnerAdapter extends ArrayAdapter<Obra> {

    public ObraSpinnerAdapter(Context context, ArrayList<Obra> obras) {
        super(context, android.R.layout.simple_spinner_item, obras);
        setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        TextView textView = view.findViewById(android.R.id.text1);

        // Obtener la obra actual en esta posición del spinner
        Obra obra = getItem(position);

        // Mostrar la información deseada en el TextView
        if (obra != null) {
            String displayText = obra.getFechaActuacion() + " - " + obra.getHoraActuacion();
            textView.setText(displayText);
        }

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}

