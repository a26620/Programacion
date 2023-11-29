package com.example.loginandroid_29_09_2023.list_genero.data;

import com.example.loginandroid_29_09_2023.beans.Genero;

import java.util.ArrayList;

public class DataGeneros {
    private String message;
    private ArrayList<Genero> generosList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Genero> getGenerosList() {
        return generosList;
    }

    public void setProductList(ArrayList<Genero> generosList) {
        this.generosList = generosList;
    }
}
