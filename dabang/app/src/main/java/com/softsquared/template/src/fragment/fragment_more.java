package com.softsquared.template.src.fragment;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.softsquared.template.R;

public class fragment_more extends Fragment implements View.OnClickListener {
    private View view;
    private TextView call_center;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_more, container, false);

        call_center=view.findViewById(R.id.call_center);
        call_center.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        String tel = "tel:0218996840";
        switch(view.getId()){
            case R.id.call_center:
                startActivity(new Intent("android.intent.action.DIAL", Uri.parse(tel)));
                break;

        }
    }
}

