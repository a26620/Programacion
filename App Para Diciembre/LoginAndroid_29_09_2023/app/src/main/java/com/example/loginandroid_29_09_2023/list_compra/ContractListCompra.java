package com.example.loginandroid_29_09_2023.list_compra;

import com.example.loginandroid_29_09_2023.beans.Compra;

import java.util.ArrayList;

public interface ContractListCompra {
    public interface View{
        public void successlistCompras(ArrayList<Compra> lstCompra);
        void failureLogin(String err);
        // void failureLogin(MyException err);
    }
    public interface Presenter{
        // void login(String email, String pass);
        void listCompras(int id_user);
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnListCompraListener{
            void onFinished(ArrayList<Compra> lstCompra);
            void onFailure(String err);
        }
        void listCompraAPI(int id_user, OnListCompraListener onListCompraListener);
    }
}
