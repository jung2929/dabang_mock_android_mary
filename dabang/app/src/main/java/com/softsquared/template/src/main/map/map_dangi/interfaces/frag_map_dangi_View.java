package com.softsquared.template.src.main.map.map_dangi.interfaces;

import com.softsquared.template.src.main.map.map_dangi.models.FragMapResponse;

public interface frag_map_dangi_View {
    //Activity와 Service는 View를 통해 데이터를 주고받음

    //void validateSuccess(String complexName,String complexAdress,String complexImg,String kindOfBuilding,String householdNum,String completionDate);
    //void validateSuccess(String text);
    void validateSuccess(FragMapResponse.result result);

    void validateFailure(String message);
}
