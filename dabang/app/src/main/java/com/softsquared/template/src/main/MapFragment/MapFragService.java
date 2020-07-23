package com.softsquared.template.src.main.MapFragment;

import com.softsquared.template.src.main.MapFragment.interfaces.MapFragView;
import com.softsquared.template.src.main.MapFragment.interfaces.MapRetrofitInterface;
import com.softsquared.template.src.main.MapFragment.models.FragMapResponse;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class MapFragService {
    private final MapFragView mMapFragView; //

    MapFragService(final MapFragView mapFragView) {
        this.mMapFragView = mapFragView;
    }

    void getMap() { //서버통신
        //비동기 방식 != 순차적
        final MapRetrofitInterface mapRetrofitInterface = getRetrofit().create(MapRetrofitInterface.class);
        mapRetrofitInterface.getMap().enqueue(new Callback <FragMapResponse>() {
            @Override
            public void onResponse(Call<FragMapResponse> call, Response<FragMapResponse> response) {
                final FragMapResponse fragMapResponse = response.body(); //response:서버에서 받아온 값
                //DefaultResponse는 자동으로 값을 파싱해줌
                if (fragMapResponse == null) {
                    mMapFragView.validateFailure(null);
                    return;
                }

                mMapFragView.validateSuccess(fragMapResponse.getMessage());
                //성공하면 파싱한 값을 넘겨줌


                //MainActivity에 있는 validateFailure(),validateSuccess()가 돌게됨
            }

            @Override
            public void onFailure(Call<FragMapResponse> call, Throwable t) { //통신실패
                mMapFragView.validateFailure(null);
            }
        });
    }
}
