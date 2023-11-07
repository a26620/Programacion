package com.example.retrofitservlet;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
  /*
    @FormUrlEncoded
    @POST("/login")
    Call<ApiResponse> login(@Field("username") String username, @Field("password") String password);
*/
      @Headers({
              "Accept: application/json",
              "Content-Type: application/json"
      })
          @GET("MyServlet")
          Call<MyData> getMyData(@Query("id") String id);

        @GET("MyServlet")
        Call<MyData> getMyDataMovies(@Query("ACTION") String action);


        @GET("MyServlet/{id}")
        Call<MyData> getMyDataURL(@Path("id") String id);

}
