package com.softsquared.template.src.heart_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.softsquared.template.R;

public class frag_call_estate extends Fragment {
    private View view;

    public static frag_call_estate newInstance(){
        frag_call_estate frag_call_estate = new frag_call_estate();
        return frag_call_estate;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_call_estate,container,false);
        //최근 본 방 프래그먼트 불러오기
        return view;
    }
}