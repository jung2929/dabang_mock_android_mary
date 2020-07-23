package com.softsquared.template.src.main.HeartFragment.heart_bang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.softsquared.template.R;

public class HeartRoomFragment extends Fragment {
    private View view;

    public static HeartRoomFragment newInstance(){
        HeartRoomFragment frag_heart_bang = new HeartRoomFragment();
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
