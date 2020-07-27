package com.softsquared.template.src.main.Home;

import com.softsquared.template.src.main.Home.interfaces.HomeFragView;
import com.softsquared.template.src.main.Home.interfaces.HomeRetrofitInterface;
import com.softsquared.template.src.main.Home.models.FragHomeResponse;
import com.softsquared.template.src.main.Home.models.postInfo;
import com.softsquared.template.src.main.interfaces.MainActivityView;
import com.softsquared.template.src.main.interfaces.MainRetrofitInterface;
import com.softsquared.template.src.main.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class HomeFragService {
    private final HomeFragView mHomeFragView; //

    HomeFragService(final HomeFragView homeFragView) {
        this.mHomeFragView = homeFragView;
    }

   void getHome() { //서버통신
        //비동기 방식 != 순차적
        final HomeRetrofitInterface homeRetrofitInterface = getRetrofit().create(HomeRetrofitInterface.class);
       homeRetrofitInterface.getHome().enqueue(new Callback<FragHomeResponse>() {
            @Override
            public void onResponse(Call<FragHomeResponse> call, Response<FragHomeResponse> response) {
                final FragHomeResponse fragHomeResponse = response.body(); //response:서버에서 받아온 값
                //DefaultResponse는 자동으로 값을 파싱해줌
                if (fragHomeResponse == null) {
                    mHomeFragView.validateFailure(null);
                    return;
                }

                mHomeFragView.validateSuccess(fragHomeResponse.getMessage());
                //mHomeFragView.homeRecommendSuccess(FragHomeResponse.getPostList());
                //성공하면 파싱한 값을 넘겨줌


                //MainActivity에 있는 validateFailure(),validateSuccess()가 돌게됨
            }

            @Override
            public void onFailure(Call<FragHomeResponse> call, Throwable t) { //통신실패
                mHomeFragView.validateFailure(null);
            }
        });
    }
}
