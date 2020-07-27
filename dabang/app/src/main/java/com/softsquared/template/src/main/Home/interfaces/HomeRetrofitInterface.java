package com.softsquared.template.src.main.Home.interfaces;

import com.softsquared.template.src.main.Home.models.FragHomeResponse;
import com.softsquared.template.src.main.Map.models.FragMapResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HomeRetrofitInterface {
    //    @GET("/test")
    @GET("/contents")
     Call<FragHomeResponse> getHome();

//    @GET("/test/{number}")
//    Call<DefaultResponse> getTestPathAndQuery(
//            @Path("number") int number,
//            @Query("content") final String content
//    );
//
//    @POST("/test")
//    Call<DefaultResponse> postTest(@Body RequestBody params);
}
