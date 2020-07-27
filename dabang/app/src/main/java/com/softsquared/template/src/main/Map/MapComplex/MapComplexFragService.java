package com.softsquared.template.src.main.Map.MapComplex;


import com.softsquared.template.src.main.Map.MapComplex.interfaces.MapComplexFragRetrofitInterface;
import com.softsquared.template.src.main.Map.MapComplex.interfaces.MapComplexFragView;
import com.softsquared.template.src.main.Map.MapComplex.models.FragMapComplexResponse;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class MapComplexFragService {
    private final MapComplexFragView mMapComplexFragView; //

    MapComplexFragService(final MapComplexFragView mapComplexFragView) {
       this.mMapComplexFragView = mapComplexFragView;

    }

    void getComplex(String address, String roomType) { //서버통신
        //비동기 방식 != 순차적
        final MapComplexFragRetrofitInterface frag_map_retrofitInterface = getRetrofit().create(MapComplexFragRetrofitInterface.class);
        frag_map_retrofitInterface.getComplex(address,roomType).enqueue(new Callback <FragMapComplexResponse>() {
            @Override
            public void onResponse(Call <FragMapComplexResponse> call, Response<FragMapComplexResponse> response) {
                final FragMapComplexResponse fragMapComplexResponse = response.body(); //response:서버에서 받아온 값
                //FragMapResponse는 자동으로 값을 파싱해줌
                if (fragMapComplexResponse == null) {
                    //System.out.println("여기까지 오나");
                    mMapComplexFragView.validateFailure(null);
                    return;
                }

                //System.out.println("여기까지 오나");
                //mfrag_map_dangi_view.validateSuccess(fragMapResponse.getMessage());
                mMapComplexFragView.validateSuccess(fragMapComplexResponse.getResult());//이 줄만 고쳐서 파싱한 정보 넘겨주기


                //frag_map_dangi에 있는 validateFailure(),validateSuccess()가 돌게됨
            }

            @Override
            public void onFailure(Call<FragMapComplexResponse> call, Throwable t) {
                //System.out.println("여기까지 오나2");
                mMapComplexFragView.validateFailure(null);
            }


        });
    }


}
