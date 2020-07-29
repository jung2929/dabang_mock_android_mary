package com.softsquared.template.src.main.Map.MapComplex;

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
import com.softsquared.template.src.main.Map.MapComplex.models.ComplexInfo;
import com.softsquared.template.src.main.Map.MapComplex.models.FragMapComplexResponse;
import com.softsquared.template.src.main.Map.MapComplex.Adapter.ComplexAdapter;
import com.softsquared.template.src.main.Map.MapComplex.interfaces.MapComplexFragView;


import java.util.ArrayList;

public class MapComplexFragment extends Fragment implements MapComplexFragView {

    ArrayList<ComplexInfo> complexInfos = new ArrayList<>();

    private View view;
    private ArrayList<ComplexInfo> complex;
    private static ListView listview;
    private static ComplexAdapter complexAdapter;
    Handler MapComplexHandler;

    public static MapComplexFragment newInstance() {
        MapComplexFragment frag_map_dangi = new MapComplexFragment();
        return frag_map_dangi;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_map_dangi, container, false);
        //최근 본 방 프래그먼트 불러오기
        complex = new ArrayList<>();

        MapComplexHandler = new Handler();
        Thread MapComplexThread = new Thread(new Runnable() {
            @Override
            public void run() {
                getComplexInfo();
            }
        });
        MapComplexThread.start();

          listview = view.findViewById(R.id.frag_map_dangi_list);
//        complexAdapter = new ComplexAdapter(getContext(), complex);
//        listview.setAdapter(complexAdapter);

//        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position == 0) {
//                    Intent intent1 = new Intent(getActivity(), LoginActivity.class);
//                    startActivity(intent1);
//                }
//                if (position == 1) {
//                    Intent intent2 = new Intent(getActivity(), SearchActivity.class);
//                    startActivity(intent2);
//                }
//            }
//        });
        return view;
    }

    private void getComplexInfo() {
        final MapComplexFragService fragService = new MapComplexFragService(this);
        fragService.getComplex("서울특별시 강남구 대치동", "원룸|오피스텔|아파트|투쓰리룸"); //MainActivity에서 통신하는 방법: MainService객체를 생성하고 함수호출
        //고칠필요 x
    }


    @Override  //매개변수 고치기
    public void validateSuccess(FragMapComplexResponse.result result) {
//        ArrayList<ComplexInfo> complexInfos = new ArrayList<>();
        FragMapComplexResponse.ComplexList[] cl = result.getComplexList();
        int clSize = cl.length;
        for (int i = 0 ; i < clSize; i++) {


            complexInfos.add(new ComplexInfo(
                    cl[i].getComplexName(),
                    cl[i].getKindOfBuilding(),
                    cl[i].getHouseholdNum(),
                    cl[i].getCompletionDate(),
                    cl[i].getComplexAddress(),
                    cl[i].getComplexImg()));
        }


        complexAdapter = new ComplexAdapter(getContext(), complexInfos);
        listview.setAdapter(complexAdapter);
    }

        @Override
        public void validateFailure(String message){
            System.out.println("실패");
        }

    }






