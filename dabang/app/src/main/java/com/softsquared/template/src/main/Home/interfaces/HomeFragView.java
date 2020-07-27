package com.softsquared.template.src.main.Home.interfaces;

import com.softsquared.template.src.main.Home.models.FragHomeResponse;
import com.softsquared.template.src.main.Home.models.postInfo;
import com.softsquared.template.src.main.Map.models.FragMapResponse;

import java.util.ArrayList;

public interface HomeFragView {
    //Activity와 Service는 View를 통해 데이터를 주고받음

    void validateSuccess(String message);

    void validateFailure(String message);

   // void homeRecommendSuccess(ArrayList<postInfo> postList);
}
