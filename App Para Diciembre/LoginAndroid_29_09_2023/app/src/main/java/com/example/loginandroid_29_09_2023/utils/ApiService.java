package com.example.loginandroid_29_09_2023.utils;

import com.example.loginandroid_29_09_2023.add_obra.data.DataObras;
import com.example.loginandroid_29_09_2023.add_valoracion.data.DataValoracion;
import com.example.loginandroid_29_09_2023.list_sala.data.DataSalas;
import com.example.loginandroid_29_09_2023.login_user.data.DataUsers;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ApiService {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })


    @GET("MyServlet")
    Call<DataUsers> loginUser(@Query("ACTION") String action,
                              @Query("USER") String user,
                              @Query("PASS") String pass);
    @GET("MyServlet")
    Call<DataObras> addObra(@Query("ACTION") String action,
                            @Query("TITULO") String user,
                            @Query("DESCRIPCION") String desc,
                            @Query("PRECIO") float precio,
                            @Query("IMG") String img,
                            @Query("ID_SALA") int id_sala,
                            @Query("FECHA") String fechaActuacion);

    @GET("MyServlet")
    Call<DataSalas> listSala(@Query("ACTION") String action);

    @GET("MyServlet")
    Call<DataObras> listObras(@Query("ACTION") String action,
                              @Query("ID_SALA") int id_sala);

    @GET("MyServlet")
    Call<DataObras> listObrasMostSell(@Query("ACTION") String action);

    @GET("MyServlet")
    Call<DataObras> listObrasFilter(@Query("ACTION") String action,
                                    @Query("ID_GENERO") ArrayList<Integer> id_genero,
                                    @Query("EDAD_RECOMENDADA") int edadRecomendada);

    @GET("MyServlet")
    Call<DataValoracion> addValoracion(@Query("ACTION") String action,
                                       @Query("ID_USER") int id_genero,
                                       @Query("ID_OBRA") int id_obra,
                                       @Query("PUNTUACION") float puntuacion);

    @GET("MyServlet")
    Call<DataObras> listObrasBestRating(@Query("ACTION") String action);

    @GET("MyServlet")
    Call<DataObras> fichaDescriptiva(@Query("ACTION") String action,
                                     @Query("ID_OBRA") int id_obra);


        /*@GET("MyServlet")
        Call<MyData> getDataUser(@Query("ACTION") String action);

        @GET("MyServlet")
        Call<DataMovies> getDataMovies(@Query("ACTION") String action);

        @GET("MyServlet")
        Call<DataMovies> getDataMovies2(@Query("ACTION") String action);


        @GET("MyServlet")
          Call<MyData> getMyData(@Query("id") String id);

        @GET("MyServlet/{id}")
        Call<MyData> getMyDataURL(@Path("id") String id);

        @FormUrlEncoded
        @POST("/login")
        Call<ApiResponse> login(@Field("username") String username, @Field("password") String password);
    */
}
