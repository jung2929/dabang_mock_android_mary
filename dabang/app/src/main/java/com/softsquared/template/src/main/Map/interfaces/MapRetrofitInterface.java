package com.softsquared.template.src.main.Map.interfaces;

import com.softsquared.template.src.main.Map.models.FragMapResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MapRetrofitInterface {
    //    @GET("/test")
    @GET("/rooms")
    Call<FragMapResponse> getMap(
            @Query("roomType") String roomType ,
            @Query("maintenanceCostMin")  String maintenanceCostMin,
            @Query("maintenanceCostMax")  String maintenanceCostMax,
            @Query("exclusiveAreaMin")  String exclusiveAreaMin,
            @Query("exclusiveAreaMax")  String exclusiveAreaMax,
            @Query("latitude")  String latitude,
            @Query("longitude")  String longitude,
            @Query("scale")  String scale

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
