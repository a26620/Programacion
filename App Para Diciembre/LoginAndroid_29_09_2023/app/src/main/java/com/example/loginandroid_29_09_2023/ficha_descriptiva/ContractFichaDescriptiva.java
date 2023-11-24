package com.example.loginandroid_29_09_2023.ficha_descriptiva;

import com.example.loginandroid_29_09_2023.ficha_descriptiva.ContractFichaDescriptiva;
import com.example.loginandroid_29_09_2023.beans.Obra;

import java.util.ArrayList;

public interface ContractFichaDescriptiva {
    public interface View{
        public void successfichaDescriptiva(Obra obra);
        void failurefichaDescriptiva(String err);
        // void failureLogin(MyException err);
    }
    public interface Presenter{
        // void login(String email, String pass);
        void fichaDescriptiva(int id);
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnFichaDescriptivaListener{
            void onFinished(Obra obra);
            void onFailure(String err);
        }
        void fichaDescriptivaAPI(int id,OnFichaDescriptivaListener onFichaDescriptivaListener);
    }
}
