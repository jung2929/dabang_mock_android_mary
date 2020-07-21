package com.softsquared.template.src.main.map.map_dangi.interfaces;

public interface frag_map_dangi_View {
    //Activity와 Service는 View를 통해 데이터를 주고받음

    void validateSuccess(String text);

    void validateFailure(String message);
}
