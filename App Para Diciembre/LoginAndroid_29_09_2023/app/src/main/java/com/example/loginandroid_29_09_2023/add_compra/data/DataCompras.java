package com.example.loginandroid_29_09_2023.add_compra.data;

import com.example.loginandroid_29_09_2023.beans.Compra;

import java.util.ArrayList;

public class DataCompras {
    private String message;
    private ArrayList<Compra> comprasList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Compra> getComprasList() {
        return comprasList;
    }

    public void setProductList(ArrayList<Compra> comprasList) {
        this.comprasList = comprasList;
    }
}
