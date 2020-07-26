package com.softsquared.template.src.main.More.Login.interfaces;

public interface LoginActivityView {
    //Activity와 Service는 View를 통해 데이터를 주고받음

    void loginSuccess();
    void validateSuccess(String text);

    void validateFailure(String message);
}
