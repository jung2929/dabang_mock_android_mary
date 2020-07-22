package com.softsquared.template.src.main.map.map_dangi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.softsquared.template.R;

import com.softsquared.template.src.Login.LoginActivity;
import com.softsquared.template.src.Search.SearchActivity;
import com.softsquared.template.src.main.map.map_dangi.Adapter.DangiAdapter;
import com.softsquared.template.src.main.map.map_dangi.interfaces.frag_map_dangi_View;
import com.softsquared.template.src.main.map.map_dangi.models.FragMapResponse;

import java.util.ArrayList;

public class frag_map_dangi extends Fragment implements frag_map_dangi_View {
    private View view;
    ArrayList<Dangi_info> dangi;
    ListView listview;
    private static DangiAdapter dangiAdapter;
    Handler handler;

    public static frag_map_dangi newInstance(){
        frag_map_dangi frag_map_dangi = new frag_map_dangi();
        return frag_map_dangi;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_map_dangi,container,false);
        //최근 본 방 프래그먼트 불러오기
        dangi = new ArrayList<>();

        handler = new Handler();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                tryGetTest();
            }
        });
        t.start();

        //addItem();
       dangi.add(new Dangi_info("하이","나왓","00","hi4","hi5"));
       dangi.add(new Dangi_info("선릉역롯데골드로즈","오피스텔,","198세대,","2003.10","서울특별시 강남구 대치동"));

        listview = view.findViewById(R.id.frag_map_dangi_list);
        dangiAdapter = new DangiAdapter(getContext(),dangi);
        listview.setAdapter(dangiAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Intent intent1 = new Intent(getActivity(), LoginActivity.class);
                    startActivity(intent1);
                }
                if(position == 1){
                    Intent intent2 = new Intent(getActivity(), SearchActivity.class);
                    startActivity(intent2);
                }
            }
        });
        return view;
    }

    private void tryGetTest() {
        final frag_map_dangi_service fragService = new frag_map_dangi_service(this);
        fragService.getTest("대치동","원룸|오피스텔|아파트|투쓰리룸"); //MainActivity에서 통신하는 방법: MainService객체를 생성하고 함수호출
        //고칠필요 x
    }


    @Override  //매개변수 고치기
    public void validateSuccess(FragMapResponse.result result) {
        //Toast.makeText(getActivity(), text, Toast.LENGTH_LONG).show(); //getContext?? getActivity?
        //System.out.println("성공!!!"+ complexName + complexAdress + complexImg + kindOfBuilding + householdNum + completionDate);
//        int num = Integer.parseInt(result.getComplexNum());
//        for(int i =1; i < num ; i++){
//        }

        for(FragMapResponse.ComplexList complexList : result.getComplexList()) {
            System.out.println(complexList.getHouseholdNum());
        }


//        for(FragMapResponse.ComplexList complexList : result.getComplexList()) {
//                String complexName = complexList.getComplexName();
//                String complexAdress = complexList.getComplexAdress();
//                String complexImg = complexList.getComplexImg();
//                String kindOfBuilding = complexList.getKindOfBuilding();
//                String householdNum = complexList.getHouseholdNum();
//                String completionDate = complexList.getCompletionDate();
//
//            addItem(complexName,complexAdress,kindOfBuilding,householdNum,completionDate);
//            //이미지 일단 보류 complexImg
//        }

    }

    @Override
    public void validateFailure(String message) {
        //Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
        System.out.println("실패");
    }


//    public void addItem(String complexName,String kindOfBuilding,String householdNum,String completionDate,String complexAdress) {
//    //이미지 url 일단 보류 String complexImg
//        dangi.add(new Dangi_info(complexName, kindOfBuilding, householdNum, completionDate, complexAdress));
//        //dangi.add(new Dangi_info("하이", "나왓", "00", "hi4", "hi5"));
//        //dangi.add(new Dangi_info("선릉역롯데골드로즈", "오피스텔,", "198세대,", "2003.10", "서울특별시 강남구 대치동"));
//    }
}