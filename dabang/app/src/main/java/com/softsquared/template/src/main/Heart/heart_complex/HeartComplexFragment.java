package com.softsquared.template.src.main.Heart.heart_complex;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.softsquared.template.R;

public class HeartComplexFragment extends Fragment {
    private View view;

    public static HeartComplexFragment newInstance(){
        HeartComplexFragment frag_heart_dangi = new HeartComplexFragment();
        return frag_heart_dangi;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_heart_dangi,container,false);
        //최근 본 방 프래그먼트 불러오기
        return view;
    }
}
