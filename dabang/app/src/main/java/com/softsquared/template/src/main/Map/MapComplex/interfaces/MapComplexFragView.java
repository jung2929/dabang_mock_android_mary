package com.softsquared.template.src.main.Map.MapComplex.interfaces;

import com.softsquared.template.src.main.Map.MapComplex.models.FragMapComplexResponse;

public interface MapComplexFragView {
    //Activity와 Service는 View를 통해 데이터를 주고받음

    //void validateSuccess(String complexName,String complexAdress,String complexImg,String kindOfBuilding,String householdNum,String completionDate);
    //void validateSuccess(String text);
    void validateSuccess(FragMapComplexResponse.result result);

    void validateFailure(String message);
}
