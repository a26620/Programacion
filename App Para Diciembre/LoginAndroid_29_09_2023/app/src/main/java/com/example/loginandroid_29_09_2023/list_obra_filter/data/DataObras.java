package com.example.loginandroid_29_09_2023.list_obra_filter.data;

import com.example.loginandroid_29_09_2023.beans.Obra;

import java.util.ArrayList;

public class DataObras {
    private String message;
    private ArrayList<Obra> obrasList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Obra> getObrasList() {
        return obrasList;
    }

    public void setProductList(ArrayList<Obra> obrasList) {
        this.obrasList = obrasList;
    }
}
