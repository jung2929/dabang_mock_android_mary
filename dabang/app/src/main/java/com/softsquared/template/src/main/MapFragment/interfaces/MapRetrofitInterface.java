package com.softsquared.template.src.main.MapFragment.interfaces;

import com.softsquared.template.src.main.MapFragment.models.FragMapResponse;
import com.softsquared.template.src.main.models.DefaultResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MapRetrofitInterface {
    //    @GET("/test")
    @GET("/rooms")
    Call<FragMapResponse> getMap(
//            @Query("dong") String dong ,
//            @Query("roomType")  String roomType
    );

//    @GET("/test/{number}")
//    Call<DefaultResponse> getTestPathAndQuery(
//            @Path("number") int number,
//            @Query("content") final String content
//    );
//
//    @POST("/test")
//    Call<DefaultResponse> postTest(@Body RequestBody params);
}
