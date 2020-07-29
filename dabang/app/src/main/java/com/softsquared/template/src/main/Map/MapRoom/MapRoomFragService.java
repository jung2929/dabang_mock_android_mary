package com.softsquared.template.src.main.Map.MapRoom;


import com.softsquared.template.src.main.Map.MapComplex.interfaces.MapComplexFragRetrofitInterface;
import com.softsquared.template.src.main.Map.MapComplex.interfaces.MapComplexFragView;
import com.softsquared.template.src.main.Map.MapComplex.models.FragMapComplexResponse;
import com.softsquared.template.src.main.Map.MapRoom.interfaces.MapRoomFragRetrofitInterface;
import com.softsquared.template.src.main.Map.MapRoom.interfaces.MapRoomFragView;
import com.softsquared.template.src.main.Map.MapRoom.models.FragMapRoomResponse;
import com.softsquared.template.src.main.Map.models.FragMapResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class MapRoomFragService {
    private final MapRoomFragView mMapRoomFragView; //

    MapRoomFragService(final MapRoomFragView mapRoomFragView) {
       this.mMapRoomFragView = mapRoomFragView;

    }

    void getRoom(String roomType,String maintenanceCostMin,String maintenanceCostMax,String exclusiveAreaMin,String exclusiveAreaMax,String latitude, String longitude,String scale) { //서버통신
        //비동기 방식 != 순차적
        final MapRoomFragRetrofitInterface mapRoomretrofitInterface = getRetrofit().create(MapRoomFragRetrofitInterface.class);
        mapRoomretrofitInterface.getRoom(roomType,maintenanceCostMin,maintenanceCostMax,exclusiveAreaMin,exclusiveAreaMax,latitude,longitude, scale).enqueue(new Callback <FragMapRoomResponse>() {
            @Override
            public void onResponse(Call <FragMapRoomResponse> call, Response<FragMapRoomResponse> response) {
                final FragMapRoomResponse fragMapRoomResponse = response.body(); //response:서버에서 받아온 값
                //FragMapResponse는 자동으로 값을 파싱해줌
                if (fragMapRoomResponse == null) {
                    //System.out.println("여기까지 오나");
                    mMapRoomFragView.validateFailure(null);
                    return;
                }


                mMapRoomFragView.validateSuccess(fragMapRoomResponse.getResult());//이 줄만 고쳐서 파싱한 정보 넘겨주기


                //frag_map_dangi에 있는 validateFailure(),validateSuccess()가 돌게됨
            }

            @Override
            public void onFailure(Call<FragMapRoomResponse> call, Throwable t) {

                mMapRoomFragView.validateFailure(null);
            }


        });
    }


}
