package com.example.loginandroid_29_09_2023.lista_obra_most_sell;

import com.example.loginandroid_29_09_2023.beans.Obra;

import java.util.ArrayList;

public interface ContractListObraMostSell {
    public interface View{
        public void successlistObrasMostSell(ArrayList<Obra> lstObra);
        void failureLogin(String err);
        // void failureLogin(MyException err);
    }
    public interface Presenter{
        // void login(String email, String pass);
        void listObraMostSell();
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnListObraMostSellListener{
            void onFinished(ArrayList<Obra> lstObra);
            void onFailure(String err);
        }
        void listObraMostSellAPI(OnListObraMostSellListener onListObraMostSellListener);
    }
}
