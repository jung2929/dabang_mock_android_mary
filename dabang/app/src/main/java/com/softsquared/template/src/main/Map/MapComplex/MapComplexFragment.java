package com.softsquared.template.src.main.Map.MapComplex;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.softsquared.template.R;
import com.softsquared.template.src.main.Map.MapComplex.models.FragMapComplexResponse;
import com.softsquared.template.src.main.More.Login.LoginActivity;
import com.softsquared.template.src.Search.SearchActivity;
import com.softsquared.template.src.main.Map.MapComplex.Adapter.ComplexAdapter;
import com.softsquared.template.src.main.Map.MapComplex.interfaces.MapComplexFragView;

import java.util.ArrayList;

public class MapComplexFragment extends Fragment implements MapComplexFragView {
    TextView test;

    private View view;
    private static ArrayList<ComplexInfo> complex;
    ListView listview;
    private static ComplexAdapter complexAdapter;
    Handler handler;

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

        handler = new Handler();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                getComplexInfo();
            }
        });
        t.start();

        //addItem();
        //complex.add(new ComplexInfo("하이","나왓","00","hi4","hi5","https://firebasestorage.googleapis.com/v0/b/allroom.appspot.com/o/default%2F%EB%B0%A9%20%EA%B8%B0%EB%B3%B8%EC%9D%B4%EB%AF%B8%EC%A7%80.PNG?alt=media&token=ac7a7438-5dde-4666-bccd-6ab0c07d0f36"));
        //complex.add(new ComplexInfo("선릉역롯데골드로즈","오피스텔,","198세대,","2003.10","서울특별시 강남구 대치동","https://firebasestorage.googleapis.com/v0/b/allroom.appspot.com/o/default%2F%EB%B0%A9%20%EA%B8%B0%EB%B3%B8%EC%9D%B4%EB%AF%B8%EC%A7%80.PNG?alt=media&token=ac7a7438-5dde-4666-bccd-6ab0c07d0f36"));
        test = view.findViewById(R.id.test);
        listview = view.findViewById(R.id.frag_map_dangi_list);
        complexAdapter = new ComplexAdapter(getContext(), complex);
        listview.setAdapter(complexAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent1 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent1);
                }
                if (position == 1) {
                    Intent intent2 = new Intent(getActivity(), SearchActivity.class);
                    startActivity(intent2);
                }
            }
        });
        return view;
    }

    private void getComplexInfo() {
        final MapComplexFragService fragService = new MapComplexFragService(this);
        fragService.getComplex("서울특별시 강남구 대치동", "원룸|오피스텔|아파트|투쓰리룸"); //MainActivity에서 통신하는 방법: MainService객체를 생성하고 함수호출
        //고칠필요 x
    }


    @Override  //매개변수 고치기
    public void validateSuccess(FragMapComplexResponse.result result) {


        for (FragMapComplexResponse.ComplexList complexList : result.getComplexList()) {
            String complexName = complexList.getComplexName();
            String complexAddress = complexList.getComplexAddress();
            String complexImg = complexList.getComplexImg();
            String kindOfBuilding = complexList.getKindOfBuilding();
            String householdNum = complexList.getHouseholdNum();
            String completionDate = complexList.getCompletionDate();

            //System.out.println(complexName + complexAddress + kindOfBuilding + householdNum + completionDate + complexImg);
            System.out.println("성공");
            //array.add(new ComplexInfo(complexName+" ",kindOfBuilding+" ",householdNum+" ",completionDate+" ",complexAddress+" ",complexImg+" "));

            addItem(complexName,complexAddress,kindOfBuilding,householdNum,completionDate,complexImg);

        }

    }

        @Override
        public void validateFailure(String message){
            System.out.println("실패");
        }

        public static void addItem(String complexName,String kindOfBuilding,String householdNum,String completionDate,String complexAddress,String complexImg) {
        //public void addItem() {

            //complex.add(new ComplexInfo(complexName, kindOfBuilding, householdNum, completionDate, complexAddress, complexImg));
            //System.out.println(complexName + complexAddress + kindOfBuilding + householdNum + completionDate + complexImg);
            //test.setText(complexName);

            complex.add(new ComplexInfo(complexName+" ",kindOfBuilding+" ",householdNum+" ",completionDate+" ",complexAddress+" ",complexImg+" "));
            //complex.add(new ComplexInfo("하이", "나왓", "00", "hi4", "hi5", "https://firebasestorage.googleapis.com/v0/b/allroom.appspot.com/o/default%2F%EB%B0%A9%20%EA%B8%B0%EB%B3%B8%EC%9D%B4%EB%AF%B8%EC%A7%80.PNG?alt=media&token=ac7a7438-5dde-4666-bccd-6ab0c07d0f36"));
            //complex.add(new ComplexInfo("선릉역롯데골드로즈", "오피스텔,", "198세대,", "2003.10", "서울특별시 강남구 대치동", "https://firebasestorage.googleapis.com/v0/b/allroom.appspot.com/o/default%2F%EB%B0%A9%20%EA%B8%B0%EB%B3%B8%EC%9D%B4%EB%AF%B8%EC%A7%80.PNG?alt=media&token=ac7a7438-5dde-4666-bccd-6ab0c07d0f36"));
        }
    }






