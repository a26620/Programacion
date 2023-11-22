package com.example.loginandroid_29_09_2023.add_valoracion.data;

import com.example.loginandroid_29_09_2023.beans.Valoracion;

import java.util.ArrayList;

public class DataValoracion {
    private String message;
    private ArrayList<Valoracion> valoracionList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Valoracion> getValoracionList() {
        return valoracionList;
    }

    public void setProductList(ArrayList<Valoracion> valoracionList) {
        this.valoracionList = valoracionList;
    }
}
