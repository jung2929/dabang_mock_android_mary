package com.softsquared.template.src.main.Map.interfaces;

import com.softsquared.template.src.main.Map.models.FragMapResponse;

public interface MapFragView {
    //Activity와 Service는 View를 통해 데이터를 주고받음

    void validateSuccess(FragMapResponse.result result);

    void validateFailure(String message);
}
