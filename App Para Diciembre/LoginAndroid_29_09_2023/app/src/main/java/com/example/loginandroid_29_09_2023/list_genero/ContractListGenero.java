package com.example.loginandroid_29_09_2023.list_genero;

import com.example.loginandroid_29_09_2023.beans.Genero;

import java.util.ArrayList;

public interface ContractListGenero {
    public interface View{
        public void successlistGeneros(ArrayList<Genero> lstGenero);
        void failureLogin(String err);
        // void failureLogin(MyException err);
    }
    public interface Presenter{
        // void login(String email, String pass);
        void listGeneros();
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnListGeneroListener{
            void onFinished(ArrayList<Genero> lstGenero);
            void onFailure(String err);
        }
        void listGeneroAPI(ContractListGenero.Model.OnListGeneroListener onListGeneroListener);
    }
}
