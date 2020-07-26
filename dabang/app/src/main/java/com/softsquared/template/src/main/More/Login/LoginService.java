package com.softsquared.template.src.main.More.Login;

import com.softsquared.template.src.main.More.Login.interfaces.LoginActivityView;
import com.softsquared.template.src.main.More.Login.interfaces.LoginRetrofitInterface;
import com.softsquared.template.src.main.More.Login.models.LoginResponse;
import com.softsquared.template.src.main.interfaces.MainActivityView;
import com.softsquared.template.src.main.interfaces.MainRetrofitInterface;
import com.softsquared.template.src.main.models.DefaultResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.softsquared.template.src.ApplicationClass.getRetrofit;

class LoginService {
    private final LoginActivityView mLoginActivityView; //

    LoginService(final LoginActivityView loginActivityView) {
        this. mLoginActivityView = loginActivityView;
    }

    void getTest() { //서버통신
        //비동기 방식 != 순차적
        final LoginRetrofitInterface mainRetrofitInterface = getRetrofit().create(LoginRetrofitInterface.class);
        mainRetrofitInterface.getTest().enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                final LoginResponse loginResponse = response.body(); //response:서버에서 받아온 값
                //DefaultResponse는 자동으로 값을 파싱해줌
                if (loginResponse == null) {
                    mLoginActivityView.validateFailure(null);
                    return;
                }

                mLoginActivityView.validateSuccess(loginResponse.getMessage());
                //성공하면 파싱한 값을 넘겨줌


                //MainActivity에 있는 validateFailure(),validateSuccess()가 돌게됨
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) { //통신실패
                mLoginActivityView.validateFailure(null);
            }
        });
    }
}
