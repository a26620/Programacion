package com.example.loginandroid_29_09_2023.list_obra_best_rating;

import com.example.loginandroid_29_09_2023.beans.Obra;

import java.util.ArrayList;

public interface ContractListObraBestRating {
    public interface View{
        public void successlistObrasBestRating(ArrayList<Obra> lstObra);
        void failurelistObrasBestRating(String err);
        // void failureLogin(MyException err);
    }
    public interface Presenter{
        // void login(String email, String pass);
        void listObraBestRating();
        // void login(ViewUser viewUser);
        // VIEW-ORM
        // BEANS-ENTITIES
        // MVP - MVVM
    }
    public interface Model{
        interface OnListObraBestRatingListener{
            void onFinished(ArrayList<Obra> lstObra);
            void onFailure(String err);
        }
        void listObraBestRatingAPI( OnListObraBestRatingListener onListObraBestRatingListener);
    }
}
