package com.example.loginandroid_29_09_2023.add_valoracion;

import com.example.loginandroid_29_09_2023.add_valoracion.ContractAddValoracion;
import com.example.loginandroid_29_09_2023.beans.Valoracion;
import com.example.loginandroid_29_09_2023.beans.Sala;

import java.util.ArrayList;

public interface ContractAddValoracion {
    public interface View{
        public void successAddValoracions(ArrayList<Valoracion> lstValoracion);
        void failureLogin(String err);
        // void failureLogin(MyException err);
    }
    public interface Presenter{
        // void login(String email, String pass);
        void addValoracion(int id_user, int id_obra, int puntuacion);
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnAddValoracionListener{
            void onFinished(ArrayList<Valoracion> lstValoracion);
            void onFailure(String err);
        }
        void addValoracionAPI(int id_user, int id_obra, int puntuacion,OnAddValoracionListener onAddValoracionListener);
    }
}
