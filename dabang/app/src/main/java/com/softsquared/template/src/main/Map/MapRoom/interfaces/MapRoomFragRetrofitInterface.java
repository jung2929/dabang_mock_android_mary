package com.softsquared.template.src.main.Map.MapRoom.interfaces;

import com.softsquared.template.src.main.Map.MapComplex.models.FragMapComplexResponse;
import com.softsquared.template.src.main.Map.MapRoom.models.FragMapRoomResponse;
import com.softsquared.template.src.main.Map.models.FragMapResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MapRoomFragRetrofitInterface {
    //    @GET("/test")

    @GET("/rooms")
    Call<FragMapRoomResponse> getRoom(
            @Query("roomType") String roomType ,
            @Query("maintenanceCostMin")  String maintenanceCostMin,
            @Query("maintenanceCostMax")  String maintenanceCostMax,
            @Query("exclusiveAreaMin")  String exclusiveAreaMin,
            @Query("exclusiveAreaMax")  String exclusiveAreaMax,
            @Query("latitude")  String latitude,
            @Query("longitude")  String longitude,
            @Query("scale")  String scale

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
