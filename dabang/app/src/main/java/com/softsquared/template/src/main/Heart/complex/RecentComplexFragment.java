package com.softsquared.template.src.main.Heart.complex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.softsquared.template.R;

public class RecentComplexFragment extends Fragment {
    private View view;

    public static RecentComplexFragment newInstance(){
        RecentComplexFragment frag_recent_dangi = new RecentComplexFragment();
        return frag_recent_dangi;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_recent_dangi,container,false);
        //최근 본 방 프래그먼트 불러오기
        return view;
    }
}
