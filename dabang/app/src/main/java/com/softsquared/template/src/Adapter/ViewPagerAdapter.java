package com.softsquared.template.src.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.softsquared.template.src.heart_fragment.frag_heart_bang;
import com.softsquared.template.src.heart_fragment.frag_recent_bang;
import com.softsquared.template.src.heart_fragment.frag_recent_dangi;

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
                return frag_recent_bang.newInstance();
            case 1:
                return frag_recent_dangi.newInstance();
            case 2:
                return frag_heart_bang.newInstance();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
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
            default:
                return null;
        }
    }
}
