package com.softsquared.template.src.main.Map.MapEstate;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.softsquared.template.R;
import com.softsquared.template.src.main.Map.MapEstate.Adapter.EstateAdapter;
import com.softsquared.template.src.main.Map.MapEstate.interfaces.MapEstateFragView;
import com.softsquared.template.src.main.Map.MapEstate.models.EstateInfo;
import com.softsquared.template.src.main.Map.MapEstate.models.FragMapEstateResponse;

import java.util.ArrayList;

public class MapEstateFragment extends Fragment implements MapEstateFragView {
    private View view;
    private static ArrayList<EstateInfo> estate;
    private static ListView MapEstateListview;
    private static EstateAdapter estateAdapter;
    Handler MapEstatehandler;

    public static MapEstateFragment newInstance(){
        MapEstateFragment frag_map_estate = new MapEstateFragment();
        return frag_map_estate;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_map_estate,container,false);
        //최근 본 방 프래그먼트 불러오기
        estate = new ArrayList<>();
        MapEstatehandler = new Handler();
        Thread mapEstateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                getEstateInfo();
            }
        });
        mapEstateThread.start();

        MapEstateListview = view.findViewById(R.id.map_state_listview);
        return view;
    }



    private void getEstateInfo() {
        final MapEstateFragService mapEstateFragService = new MapEstateFragService(this);
        mapEstateFragService.getEstate("서울특별시 강남구 대치동"); //MainActivity에서 통신하는 방법: MainService객체를 생성하고 함수호출
        //고칠필요 x
    }

    @Override
    public void validateSuccess(FragMapEstateResponse.result result) {
        for (FragMapEstateResponse.AgencyList agencyList : result.getAgencyList()) {
            String agencyName = agencyList.getAgencyName();
            String agencyAddress = agencyList.getAgencyAddress();
            String agencyComment = agencyList.getAgencyComment();
            String agencyBossImg = agencyList.getAgencyBossImg();

            //System.out.println(agencyName);
            addItem(agencyName,agencyAddress,agencyComment,agencyBossImg);

        }
    }

    @Override
    public void validateFailure(String message) {

    }


    public void addItem(String agencyName, String agencyAddress, String agencyComment, String agencyBossImg) {

        estateAdapter = new EstateAdapter(getContext(), estate);
        MapEstateListview.setAdapter(estateAdapter);
        estate.add(new EstateInfo(agencyName+" ",agencyAddress+" ",agencyComment+" ",agencyBossImg+" "));
    }
}
