package com.softsquared.template.src.main.MapFragment.MapComplex.interfaces;

import com.softsquared.template.src.main.MapFragment.MapComplex.models.FragMapComplexResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MapComplexFragRetrofitInterface {
    //    @GET("/test")

    @GET("/complexes")
    Call<FragMapComplexResponse> getComplex(
            @Query("dong") String dong ,
            @Query("roomType")  String roomType   // 고칠필요x

    );

//    @GET("/complex/list")
//    Call<FragMapResponse> getTest(
//            @Query("complexName") String complexName ,
//            @Query("complexAdress")  String complexAdress,
//            @Query("complexImg")  String complexImg,
//            @Query("kindOfBuilding")  String kindOfBuilding,
//            @Query("householdNum")  String householdNum,
//            @Query("completionDate")  String completionDate
//
//
//    );

//    @GET("/test/{result}")
//    Call<FragMapResponse> getTestPathAndQuery(
//            @Path("number") int number,
//            @Query("content") final String content
//    );
//
//    @POST("/test")
//    Call<FragMapResponse> postTest(@Body RequestBody params);
}
