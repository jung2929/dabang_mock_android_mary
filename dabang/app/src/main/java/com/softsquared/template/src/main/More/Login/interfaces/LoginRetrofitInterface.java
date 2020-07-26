package com.softsquared.template.src.main.More.Login.interfaces;

import com.softsquared.template.src.main.More.Login.models.LoginResponse;
import com.softsquared.template.src.main.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface LoginRetrofitInterface {
    //    @GET("/test")
    @GET("/jwt")
    Call<LoginResponse> getTest();
//
//    @GET("/test/{number}")
//    Call<DefaultResponse> getTestPathAndQuery(
//            @Path("number") int number,
//            @Query("content") final String content
//    );
//
//    @POST("/test")
//    Call<DefaultResponse> postTest(@Body RequestBody params);

//    @POST("/users")  //잠시 보류
//    @FormUrlEncoded
//    Call<SignupResponse> postLogin(@Field("id") String id,
//                                   @Field("password") String pwd);

}
