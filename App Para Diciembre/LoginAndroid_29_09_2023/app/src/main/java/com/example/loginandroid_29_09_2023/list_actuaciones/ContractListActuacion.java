package com.example.loginandroid_29_09_2023.list_actuaciones;

import com.example.loginandroid_29_09_2023.beans.Obra;

import java.util.ArrayList;

public interface ContractListActuacion {
    public interface View{
        public void successlistActuacions(ArrayList<Obra> lstObra);
        void failureLogin(String err);
        // void failureLogin(MyException err);
    }
    public interface Presenter{
        // void login(String email, String pass);
        void listActuacions(int id_obra);
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnListActuacionListener{
            void onFinished(ArrayList<Obra> lstObra);
            void onFailure(String err);
        }
        void listActuacionAPI(int id_obra, OnListActuacionListener onListActuacionListener);
    }
}
