package com.softsquared.template.src.main.heart.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.softsquared.template.src.main.heart.call_estate.frag_call_estate;
import com.softsquared.template.src.main.heart.heart_bang.frag_heart_bang;
import com.softsquared.template.src.main.heart.heart_dangi.frag_heart_dangi;
import com.softsquared.template.src.main.heart.info_bang.frag_info_bang;
import com.softsquared.template.src.main.heart.bang.frag_recent_bang;
import com.softsquared.template.src.main.heart.dangi.frag_recent_dangi;

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
            case 3:
                return frag_heart_dangi.newInstance();
            case 4:
                return frag_info_bang.newInstance();
            case 5:
                return frag_call_estate.newInstance();
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
