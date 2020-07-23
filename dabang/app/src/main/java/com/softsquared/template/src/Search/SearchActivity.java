package com.softsquared.template.src.Search;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.softsquared.template.R;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        clear = findViewById(R.id.search_clear);
        clear.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.search_clear:
                finish();
        }
    }
}