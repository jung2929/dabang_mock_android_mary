package com.softsquared.template.src.map_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.softsquared.template.R;

public class frag_map_dangi extends Fragment {
    private View view;

    public static frag_map_dangi newInstance(){
        frag_map_dangi frag_map_dangi = new frag_map_dangi();
        return frag_map_dangi;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_map_dangi,container,false);
        //최근 본 방 프래그먼트 불러오기
        return view;
    }
}
