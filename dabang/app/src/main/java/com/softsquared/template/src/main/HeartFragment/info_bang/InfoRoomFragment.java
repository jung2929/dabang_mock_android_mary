package com.softsquared.template.src.main.HeartFragment.info_bang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.softsquared.template.R;

public class InfoRoomFragment extends Fragment {
    private View view;

    public static InfoRoomFragment newInstance(){
        InfoRoomFragment frag_info_bang = new InfoRoomFragment();
        return frag_info_bang;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_info_bang,container,false);
        //최근 본 방 프래그먼트 불러오기
        return view;
    }
}
