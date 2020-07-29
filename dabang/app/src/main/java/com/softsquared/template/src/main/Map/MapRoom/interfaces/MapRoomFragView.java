package com.softsquared.template.src.main.Map.MapRoom.interfaces;

import com.softsquared.template.src.main.Map.MapComplex.models.FragMapComplexResponse;
import com.softsquared.template.src.main.Map.MapRoom.models.FragMapRoomResponse;
import com.softsquared.template.src.main.Map.models.FragMapResponse;

public interface MapRoomFragView {
    //Activity와 Service는 View를 통해 데이터를 주고받음


    void validateSuccess(FragMapRoomResponse.result result);

    void validateFailure(String message);
}
