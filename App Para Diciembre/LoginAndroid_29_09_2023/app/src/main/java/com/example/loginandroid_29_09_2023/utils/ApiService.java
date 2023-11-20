package com.example.loginandroid_29_09_2023.utils;

import com.example.loginandroid_29_09_2023.add_obra.data.DataObras;
import com.example.loginandroid_29_09_2023.list_sala.data.DataSalas;
import com.example.loginandroid_29_09_2023.login_user.data.DataUsers;

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
        Call<DataUsers> getDataUser(@Query("ACTION") String action,
                                    @Query("USER") String user,
                                    @Query("PASS") String pass);
    @GET("MyServlet")
        Call<DataObras> getDataObra(@Query("ACTION") String action,
                                    @Query("TITULO") String user,
                                    @Query("DESCRIPCION") String desc,
                                    @Query("PRECIO") float precio,
                                    @Query("IMG") String img);
    @GET("MyServlet")
    Call<DataSalas> getDataSala(@Query("ACTION") String action);

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
