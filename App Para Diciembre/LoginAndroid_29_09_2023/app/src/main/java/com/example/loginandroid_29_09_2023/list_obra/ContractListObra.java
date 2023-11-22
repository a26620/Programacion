package com.example.loginandroid_29_09_2023.list_obra;

import com.example.loginandroid_29_09_2023.add_obra.ContractAddObra;
import com.example.loginandroid_29_09_2023.beans.Obra;
import com.example.loginandroid_29_09_2023.beans.Sala;

import java.util.ArrayList;

public interface ContractListObra {
    public interface View{
        public void successlistObras(ArrayList<Obra> lstObra);
        void failureLogin(String err);
        // void failureLogin(MyException err);
    }
    public interface Presenter{
        // void login(String email, String pass);
        void listObra(int id);
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnListObraListener{
            void onFinished(ArrayList<Obra> lstObra);
            void onFailure(String err);
        }
        void listObraAPI(int id,OnListObraListener onListObraListener);
    }
}
