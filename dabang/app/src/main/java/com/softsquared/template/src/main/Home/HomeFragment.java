package com.softsquared.template.src.main.Home;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amar.library.ui.StickyScrollView;
import com.aqoong.lib.slidephotoviewer.MaxSizeException;
import com.aqoong.lib.slidephotoviewer.SlidePhotoViewer;
import com.softsquared.template.R;
import com.softsquared.template.src.Search.SearchActivity;
import com.softsquared.template.src.main.Home.Adapter.InterestRecyclerviewAdapter;
import com.softsquared.template.src.main.Home.interfaces.HomeFragView;
import com.softsquared.template.src.main.Home.models.InterestInfo;
import com.softsquared.template.src.main.Home.models.postInfo;
import java.util.ArrayList;



public class HomeFragment extends Fragment implements View.OnClickListener, HomeFragView {
    private View view;
    private LinearLayout btn_search;
    private LinearLayout titleLayout;
    Handler handler3;
    public static ArrayList<postInfo> sPostInfo;
    TextView home_recommend;
    SlidePhotoViewer homeSlider;
    private RecyclerView interestList;
    private InterestRecyclerviewAdapter interestAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);


        handler3 = new Handler();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                getHomeInfo();
            }
        });
        t.start();

        init();
        homeSlider = view.findViewById(R.id.homeSlider);
        homeSlider.setSidePreview(true);
        try {
            homeSlider.addResource(R.drawable.homead1, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "TEST", Toast.LENGTH_LONG).show();
                }
            });
            homeSlider.addResource(R.drawable.homead2, null);
            homeSlider.addResource(R.drawable.homead3, null);


        } catch (MaxSizeException e) {
            e.printStackTrace();
        }

        btn_search = view.findViewById(R.id.btn_search);
        btn_search.setOnClickListener(this);

        home_recommend = view.findViewById(R.id.home_recommend);
        titleLayout=view.findViewById(R.id.titleLayout);
        titleLayout.setClickable(true);

        return view;
    }


    private void getHomeInfo() {
        final HomeFragService homefragService = new HomeFragService(this);
        homefragService.getHome(); //MainActivity에서 통신하는 방법: MainService객체를 생성하고 함수호출
        //고칠필요 x
    }

    private void init() {

        interestList = view.findViewById(R.id.interestList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        interestList.setLayoutManager(layoutManager);

        ArrayList<InterestInfo> itemList = new ArrayList<>();

        itemList.add(new InterestInfo("잘","나왔으면","https://firebasestorage.googleapis.com/v0/b/allroom.appspot.com/o/university%2F%EC%9D%B8%ED%95%98%EB%8C%80%ED%95%99%EA%B5%90.PNG?alt=media&token=b181dc7c-2725-44d3-b35f-67bfc08a6c3d","졸려요"));

        itemList.add(new InterestInfo("잘","나왔으면","https://firebasestorage.googleapis.com/v0/b/allroom.appspot.com/o/university%2F%EC%9D%B8%ED%95%98%EB%8C%80%ED%95%99%EA%B5%90.PNG?alt=media&token=b181dc7c-2725-44d3-b35f-67bfc08a6c3d","졸려요"));
//        itemList.add("0");
//        itemList.add("1");
//        itemList.add("2");
//        itemList.add("3");
//        itemList.add("4");
//        itemList.add("5");
//        itemList.add("6");
//        itemList.add("7");
//        itemList.add("8");
//        itemList.add("9");
//        itemList.add("10");
//        itemList.add("11");

        interestAdapter = new InterestRecyclerviewAdapter(getActivity(), itemList, onClickItem);
        interestList.setAdapter(interestAdapter);

        MyListDecoration decoration = new MyListDecoration();
        interestList.addItemDecoration(decoration);
    }

    private View.OnClickListener onClickItem = new View.OnClickListener() { //item클릭시
        @Override
        public void onClick(View v) {
            String str = (String) v.getTag();
            Toast.makeText(getContext(), str, Toast.LENGTH_SHORT).show();
        }
    };



    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_search:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
        }

    }

    @Override
    public void validateSuccess(String message) {
        home_recommend.setText(message);


    }

    @Override
    public void validateFailure(String message) {

    }


}

