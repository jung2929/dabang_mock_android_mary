package com.softsquared.template.src.main.Map.MapEstate.interfaces;

import com.softsquared.template.src.main.Map.MapComplex.models.FragMapComplexResponse;
import com.softsquared.template.src.main.Map.MapEstate.models.FragMapEstateResponse;

public interface MapEstateFragView {
    //Activity와 Service는 View를 통해 데이터를 주고받음


    void validateSuccess(FragMapEstateResponse.result result);

    void validateFailure(String message);
}
