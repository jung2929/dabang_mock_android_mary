package com.softsquared.template.src.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.softsquared.template.R;
import com.softsquared.template.SearchActivity;

public class fragment_home extends Fragment implements View.OnClickListener{
    private View view;
    private SearchView btn_search;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);

        btn_search = view.findViewById(R.id.btn_search);
        btn_search.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn_search:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
        }

    }
}

