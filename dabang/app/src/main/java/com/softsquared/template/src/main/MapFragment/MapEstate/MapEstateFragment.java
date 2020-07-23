package com.softsquared.template.src.main.MapFragment.MapEstate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.softsquared.template.R;

public class MapEstateFragment extends Fragment {
    private View view;

    public static MapEstateFragment newInstance(){
        MapEstateFragment frag_map_estate = new MapEstateFragment();
        return frag_map_estate;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_map_estate,container,false);
        //최근 본 방 프래그먼트 불러오기
        return view;
    }
}
