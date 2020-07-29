package com.softsquared.template.src.main.Map.MapRoom;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.softsquared.template.R;
import com.softsquared.template.src.main.Map.MapRoom.interfaces.MapRoomFragView;
import com.softsquared.template.src.main.Map.MapRoom.models.FragMapRoomResponse;

public class MapRoomFragment extends Fragment implements MapRoomFragView {
    private View view;
    Handler mapRoomHandler;

    public static MapRoomFragment newInstance(){
        MapRoomFragment frag_map_bang = new MapRoomFragment();
        return frag_map_bang;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_map_bang,container,false);
        //최근 본 방 프래그먼트 불러오기


        mapRoomHandler = new Handler();
        Thread mapRoomThread = new Thread(new Runnable() {
            @Override
            public void run() {
                getRoomInfo();
            }
        });
        mapRoomThread.start();
        return view;
    }


    private void getRoomInfo() {
        final MapRoomFragService fragRoomService = new MapRoomFragService(this);
        fragRoomService.getRoom("원룸|오피스텔|아파트|투쓰리룸","0","999999999","0","99999999","37.5055200000","127.0783540000","10000000"); //MainActivity에서 통신하는 방법: MainService객체를 생성하고 함수호출
        //고칠필요 x
    }

    @Override
    public void validateSuccess(FragMapRoomResponse.result result) {
        System.out.println("Room성공");
    }

    @Override
    public void validateFailure(String message) {
        System.out.println("Room실패");
    }
}
