package com.softsquared.template.src.main.Map.MapEstate;


import com.softsquared.template.src.main.Map.MapComplex.interfaces.MapComplexFragRetrofitInterface;
import com.softsquared.template.src.main.Map.MapComplex.interfaces.MapComplexFragView;
import com.softsquared.template.src.main.Map.MapComplex.models.FragMapComplexResponse;
import com.softsquared.template.src.main.Map.MapEstate.interfaces.MapEstateFragRetrofitInterface;
import com.softsquared.template.src.main.Map.MapEstate.interfaces.MapEstateFragView;
import com.softsquared.template.src.main.Map.MapEstate.models.FragMapEstateResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class MapEstateFragService {
    private final MapEstateFragView mMapEstateFragView; //

    MapEstateFragService(final MapEstateFragView mapEstateFragView) {
       this.mMapEstateFragView = mapEstateFragView;

    }

    void getEstate(String address) { //서버통신
        //비동기 방식 != 순차적
        final MapEstateFragRetrofitInterface EstateretrofitInterface = getRetrofit().create(MapEstateFragRetrofitInterface.class);
        EstateretrofitInterface.getComplex(address).enqueue(new Callback <FragMapEstateResponse>() {
            @Override
            public void onResponse(Call <FragMapEstateResponse> call, Response<FragMapEstateResponse> response) {
                final FragMapEstateResponse fragMapEstateResponse = response.body(); //response:서버에서 받아온 값
                //FragMapResponse는 자동으로 값을 파싱해줌
                if (fragMapEstateResponse == null) {
                    //System.out.println("여기까지 오나");
                    mMapEstateFragView.validateFailure(null);
                    return;
                }


                mMapEstateFragView.validateSuccess(fragMapEstateResponse.getResult());//이 줄만 고쳐서 파싱한 정보 넘겨주기


                //frag_map_dangi에 있는 validateFailure(),validateSuccess()가 돌게됨
            }

            @Override
            public void onFailure(Call<FragMapEstateResponse> call, Throwable t) {
                //System.out.println("여기까지 오나2");
                mMapEstateFragView.validateFailure(null);
            }


        });
    }


}
