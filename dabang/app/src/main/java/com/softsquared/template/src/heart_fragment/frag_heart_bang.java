package com.softsquared.template.src.heart_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.softsquared.template.R;

public class frag_heart_bang extends Fragment {
    private View view;

    public static frag_heart_bang newInstance(){
        frag_heart_bang frag_heart_bang = new frag_heart_bang();
        return frag_heart_bang;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_heart_bang,container,false);
        //최근 본 방 프래그먼트 불러오기
        return view;
    }
}
