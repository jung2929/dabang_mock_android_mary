package com.softsquared.template.src.main.Map.MapEstate.interfaces;

import com.softsquared.template.src.main.Map.MapComplex.models.FragMapComplexResponse;
import com.softsquared.template.src.main.Map.MapEstate.models.FragMapEstateResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MapEstateFragRetrofitInterface {
    //    @GET("/test")

    @GET("/agencies")
    Call<FragMapEstateResponse> getComplex(
            @Query("address") String address


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
