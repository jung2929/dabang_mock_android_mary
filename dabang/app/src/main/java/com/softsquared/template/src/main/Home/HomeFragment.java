package com.softsquared.template.src.main.Home;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.amar.library.ui.StickyScrollView;
import com.softsquared.template.R;
import com.softsquared.template.src.Search.SearchActivity;
import com.softsquared.template.src.main.Home.interfaces.HomeFragView;
import com.softsquared.template.src.main.Home.models.FragHomeResponse;
import com.softsquared.template.src.main.Home.models.postInfo;


import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class HomeFragment extends Fragment implements View.OnClickListener, HomeFragView {
    private View view;
    private LinearLayout btn_search;
    private ViewPager viewPager;
    private AutoScrollAdapter autoScrollAdapter;
    private StickyScrollView stickyScrollView;
    private static final int SCROLL_DIRECTION_UP = 1;
    private LinearLayout titleLayout;
    Handler handler3;
    public static ArrayList<postInfo> sPostInfo;
    TextView home_recommend;

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.

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

        btn_search = view.findViewById(R.id.btn_search);
        btn_search.setOnClickListener(this);

        viewPager = view.findViewById(R.id.home_viewPager);
        autoScrollAdapter = new AutoScrollAdapter(getActivity());
        viewPager.setAdapter(autoScrollAdapter);

        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            @Override
            public void run() {
                if(currentPage == 9) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

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

