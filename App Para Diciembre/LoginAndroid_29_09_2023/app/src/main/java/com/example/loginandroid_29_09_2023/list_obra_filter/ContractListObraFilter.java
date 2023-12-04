package com.example.loginandroid_29_09_2023.list_obra_filter;

import androidx.recyclerview.widget.GridLayoutManager;

import com.example.loginandroid_29_09_2023.adaptadores.listaFilterObra;
import com.example.loginandroid_29_09_2023.beans.Obra;

import java.util.ArrayList;

public interface ContractListObraFilter {
    public interface View{
        public void successlistObrasFilter(ArrayList<Obra> lstObra);
        public void failurelistObrasFilter(String err);
    }
    public interface Presenter{
        // void login(String email, String pass);
        void listObraFilter(ArrayList<Integer> id_genero,ArrayList<Integer> edadRecomendada,String titulo);
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnListObraFilterListener{
            void onFinished(ArrayList<Obra> lstObra);
            void onFailure(String err);
        }
        void listObraFilterAPI(ArrayList<Integer> id_genero,ArrayList<Integer> edadRecomendada,String titulo, OnListObraFilterListener onListObraFilterListener);
    }
}
