package com.softsquared.template.src.main;

import com.softsquared.template.src.main.interfaces.MainRetrofitInterface;
import com.softsquared.template.src.main.models.DefaultResponse;
import com.softsquared.template.src.main.interfaces.MainActivityView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class MainService {
    private final MainActivityView mMainActivityView; //

    MainService(final MainActivityView mainActivityView) {
        this.mMainActivityView = mainActivityView;
    }

    void getTest() { //서버통신
        //비동기 방식 != 순차적
        final MainRetrofitInterface mainRetrofitInterface = getRetrofit().create(MainRetrofitInterface.class);
        mainRetrofitInterface.getTest().enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                final DefaultResponse defaultResponse = response.body(); //response:서버에서 받아온 값
                //DefaultResponse는 자동으로 값을 파싱해줌
                if (defaultResponse == null) {
                    mMainActivityView.validateFailure(null);
                    return;
                }

                mMainActivityView.validateSuccess(defaultResponse.getMessage());
                //성공하면 파싱한 값을 넘겨줌


                //MainActivity에 있는 validateFailure(),validateSuccess()가 돌게됨
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) { //통신실패
                mMainActivityView.validateFailure(null);
            }
        });
    }
}
