package com.softsquared.template.src.main.More;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.softsquared.template.src.main.More.Login.LoginActivity;
import com.softsquared.template.R;

public class MoreFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView call_center;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_more, container, false);

        LinearLayout login = view.findViewById(R.id.login);

        call_center=view.findViewById(R.id.call_center);
        call_center.setOnClickListener(this);
        login.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        String tel = "tel:0218996840";
        switch(view.getId()){
            case R.id.call_center:
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse(tel)));
                break;
            case R.id.login:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);

        }
    }
}

