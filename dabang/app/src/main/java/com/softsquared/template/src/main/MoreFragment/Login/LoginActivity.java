package com.softsquared.template.src.main.MoreFragment.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.softsquared.template.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText ID,password;
    ImageView clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        clear = findViewById(R.id.login_clear);
        clear.setOnClickListener(this);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        ID = findViewById(R.id.ID);
        password = findViewById(R.id.password);
        ID.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == event.KEYCODE_ENTER)
                {
                    return true;
                }
                return false;
            }
        });

        password.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == event.KEYCODE_ENTER)
                {
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login_clear:
                finish();
        }
    }
}