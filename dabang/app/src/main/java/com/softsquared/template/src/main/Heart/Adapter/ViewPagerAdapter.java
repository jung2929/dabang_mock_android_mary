package com.softsquared.template.src.main.Heart.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.softsquared.template.src.main.Heart.call_estate.CallEstateFragment;
import com.softsquared.template.src.main.Heart.heart_bang.HeartRoomFragment;
import com.softsquared.template.src.main.Heart.heart_complex.HeartComplexFragment;
import com.softsquared.template.src.main.Heart.info_bang.InfoRoomFragment;
import com.softsquared.template.src.main.Heart.bang.RecentRoomFragment;
import com.softsquared.template.src.main.Heart.complex.RecentComplexFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    //프래그먼트 교체를 보여주는 처리를 구현
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return RecentRoomFragment.newInstance();
            case 1:
                return RecentComplexFragment.newInstance();
            case 2:
                return HeartRoomFragment.newInstance();
            case 3:
                return HeartComplexFragment.newInstance();
            case 4:
                return InfoRoomFragment.newInstance();
            case 5:
                return CallEstateFragment.newInstance();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 6;
    }

    //상단 TabLayout 인디케이터 쪽에 텍스트를 선언
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "최근 본 방";
            case 1:
                return "최근 본 단지";
            case 2:
                return "찜한 방";
            case 3:
                return "찜한 단지";
            case 4:
                return "문의한 방";
            case 5:
                return "연락한 부동산";
            default:
                return null;
        }
    }
}
