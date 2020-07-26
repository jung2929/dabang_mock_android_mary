package com.softsquared.template.src.main.Map.MapRoom;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.softsquared.template.R;

public class MapRoomFragment extends Fragment {
    private View view;

    public static MapRoomFragment newInstance(){
        MapRoomFragment frag_map_bang = new MapRoomFragment();
        return frag_map_bang;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_map_bang,container,false);
        //최근 본 방 프래그먼트 불러오기
        return view;
    }
}
