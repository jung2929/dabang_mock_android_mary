package com.softsquared.template.src.main.MapFragment.interfaces;

public interface MapFragView {
    //Activity와 Service는 View를 통해 데이터를 주고받음

    void validateSuccess(String text);

    void validateFailure(String message);
}
