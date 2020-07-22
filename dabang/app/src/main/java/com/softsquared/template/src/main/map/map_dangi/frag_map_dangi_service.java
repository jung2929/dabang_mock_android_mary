package com.softsquared.template.src.main.map.map_dangi;


import com.softsquared.template.src.main.map.map_dangi.interfaces.frag_map_RetrofitInterface;
import com.softsquared.template.src.main.map.map_dangi.interfaces.frag_map_dangi_View;
import com.softsquared.template.src.main.map.map_dangi.models.FragMapResponse;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class frag_map_dangi_service {
    private final frag_map_dangi_View mfrag_map_dangi_view; //

    frag_map_dangi_service(final frag_map_dangi_View FragMapDangiView) {
       this.mfrag_map_dangi_view = FragMapDangiView;

    }

    void getTest(String dong, String roomType) { //서버통신
        //비동기 방식 != 순차적
        final frag_map_RetrofitInterface frag_map_retrofitInterface = getRetrofit().create(frag_map_RetrofitInterface.class);
        frag_map_retrofitInterface.getTest(dong,roomType).enqueue(new Callback <FragMapResponse>() {
            @Override
            public void onResponse(Call <FragMapResponse> call, Response<FragMapResponse> response) {
                final FragMapResponse fragMapResponse = response.body(); //response:서버에서 받아온 값
                //FragMapResponse는 자동으로 값을 파싱해줌
                if (fragMapResponse == null) {
                    //System.out.println("여기까지 오나");
                    mfrag_map_dangi_view.validateFailure(null);
                    return;
                }

                //System.out.println("여기까지 오나");
                //mfrag_map_dangi_view.validateSuccess(fragMapResponse.getMessage());
                mfrag_map_dangi_view.validateSuccess(fragMapResponse.getResult());//이 줄만 고쳐서 파싱한 정보 넘겨주기
                //성공하면 파싱한 값을 넘겨줌


                //frag_map_dangi에 있는 validateFailure(),validateSuccess()가 돌게됨
            }

            @Override
            public void onFailure(Call<FragMapResponse> call, Throwable t) {
                //System.out.println("여기까지 오나2");
                mfrag_map_dangi_view.validateFailure(null);
            }


        });
    }


}
